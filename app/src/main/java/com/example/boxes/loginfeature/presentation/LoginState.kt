package com.example.boxes.loginfeature.presentation

data class LoginState(
    val email: String = "",
    val emailError: String = "",
    val password: String = "",
    val passwordError: String = "",
    val id : Long = -1,
    val idError : String = ""
)
