package com.example.boxes.registerfeature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boxes.loginfeature.domain.use_case.CheckEmail
import com.example.boxes.loginfeature.domain.use_case.CheckPassword
import com.example.boxes.registerfeature.domain.use_case.CheckRepeatedPassword
import com.example.boxes.registerfeature.domain.use_case.CheckTerms
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val checkEmail: CheckEmail,
    private val checkPassword: CheckPassword,
    private val checkRepeatedPassword: CheckRepeatedPassword,
    private val checkTerms: CheckTerms
): ViewModel() {

    var state by mutableStateOf(RegisterState())
    private set

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegisterEvent) {
        when(event) {
            is RegisterEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is RegisterEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegisterEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }
            is RegisterEvent.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }
            is RegisterEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = checkEmail.execute(state.email)
        val passwordResult = checkPassword.execute(state.password)
        val repeatedPasswordResult = checkRepeatedPassword.execute(
            state.password, state.repeatedPassword
        )
        val termsResult = checkTerms.execute(state.acceptedTerms)

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }

        if(hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}