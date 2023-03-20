package com.example.boxes.presentation.loginscreen

data class LoginState(
    val mail : String ="",
    val name :String ="",
    val password : String = "",
    val repeatedPassword : String =""
)