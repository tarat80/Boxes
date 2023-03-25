package com.example.boxes.registerfeature.presentation

sealed class RegisterEvent {
    data class EmailChanged(val email: String) : RegisterEvent()
    data class PasswordChanged(val password: String) : RegisterEvent()
    data class RepeatedPasswordChanged(
        val repeatedPassword: String
    ) : RegisterEvent()

    data class AcceptTerms(val isAccepted: Boolean) : RegisterEvent()

    object Submit: RegisterEvent()
}
