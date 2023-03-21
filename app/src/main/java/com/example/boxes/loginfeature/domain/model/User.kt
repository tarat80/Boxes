package com.example.boxes.loginfeature.domain.model

data class User(
    val mail : String,
    val name :String ="",
    val password : String,
    val repeatedPassword : String
) {
    interface Mapper<T> {
        fun map(
            mail: String,
            name: String,
            password: String,
            repeatedPassword: String
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(mail, name, password, repeatedPassword)
}