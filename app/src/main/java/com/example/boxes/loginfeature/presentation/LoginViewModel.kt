package com.example.boxes.loginfeature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxes.loginfeature.domain.use_case.CheckEmail
import com.example.boxes.loginfeature.domain.use_case.CheckPassword
import com.example.boxes.loginfeature.domain.use_case.RetrieveID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
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
        val authResult = retrieveID.execute(state.value.email, state.value.password)
        _state.value = _state.value.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            idError = authResult.errorMessage
        )

        val noError = listOf(
            emailResult, passwordResult,
            authResult
        ).any { it.successful }
        if (noError) {
            _state.value = _state.value.copy(id = authResult.id)
            viewModelScope.launch {
                validationEventChannel.send(ValidationEvent.Success)
            }
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}