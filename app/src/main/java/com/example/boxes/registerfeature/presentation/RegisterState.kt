package com.example.boxes.registerfeature.presentation

data class RegisterState(
    val email: String = "",
    val emailError: String = "",
    val password: String = "",
    val passwordError: String = "",
    val repeatedPassword: String = "",
    val repeatedPasswordError: String = "",
    val acceptedTerms: Boolean = false,
    val termsError: String = "",
    val id : Long = -1,
    val idError : String = ""
)
