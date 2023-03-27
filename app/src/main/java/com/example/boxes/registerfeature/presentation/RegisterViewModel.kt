package com.example.boxes.registerfeature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxes.loginfeature.domain.model.Resource
import com.example.boxes.registerfeature.domain.use_case.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val checkEmail: CheckEmail,
    private val checkPassword: CheckPassword,
    private val checkRepeatedPassword: CheckRepeatedPassword,
    private val checkTerms: CheckTerms,
    private val retrieveID: RetrieveID
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.EmailChanged -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is RegisterEvent.PasswordChanged -> {
                _state.value = _state.value.copy(password = event.password)
            }
            is RegisterEvent.RepeatedPasswordChanged -> {
                _state.value = _state.value.copy(repeatedPassword = event.repeatedPassword)
            }
            is RegisterEvent.AcceptTerms -> {
                _state.value = _state.value.copy(acceptedTerms = event.isAccepted)
            }
            is RegisterEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = checkEmail.execute(_state.value.email)
        val passwordResult = checkPassword.execute(_state.value.password)
        val repeatedPasswordResult = checkRepeatedPassword.execute(
            _state.value.password, _state.value.repeatedPassword
        )
        val termsResult = checkTerms.execute(_state.value.acceptedTerms)

        _state.value = _state.value.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            repeatedPasswordError = repeatedPasswordResult.errorMessage,
            termsError = termsResult.errorMessage
        )

        val noError = !( listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful } )

        if (noError) {
            viewModelScope.launch {
                retrieveID.execute(
                    state.value.email,
                    state.value.password
                ).onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = _state.value.copy(id = result.data)
                            validationEventChannel.send(ValidationEvent.Success)
                        }
                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                idError = result.message
                            )
                        }
                    }
                }.launchIn(this)
            }
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}