package com.example.boxes.loginfeature.domain.model

data class User(
    val mail : String,
    val name :String,
    val password : String,
    val repeatedPassword : String
)
