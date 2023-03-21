package com.example.boxes.loginfeature.presentation

data class LoginState(
    val mail : String ="",
    val name :String ="",
    val password : String = "",
    val repeatedPassword : String =""
)