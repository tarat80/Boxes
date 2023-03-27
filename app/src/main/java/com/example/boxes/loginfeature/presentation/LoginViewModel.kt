package com.example.boxes.loginfeature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxes.loginfeature.domain.model.Resource
import com.example.boxes.loginfeature.domain.use_case.CheckEmail
import com.example.boxes.loginfeature.domain.use_case.CheckPassword
import com.example.boxes.loginfeature.domain.use_case.RetrieveID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val checkEmail: CheckEmail,
    private val checkPassword: CheckPassword,
    private val retrieveID: RetrieveID
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is LoginEvent.PasswordChanged -> {
                _state.value = _state.value.copy(password = event.password)
            }
            is LoginEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = checkEmail.execute(_state.value.email)
        val passwordResult = checkPassword.execute(_state.value.password)
        _state.value = _state.value.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            idError = ""
        )
        val noError = emailResult.successful && passwordResult.successful

        if (noError) viewModelScope.launch {
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

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}