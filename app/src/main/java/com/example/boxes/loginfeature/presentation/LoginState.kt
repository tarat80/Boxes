package com.example.boxes.loginfeature.presentation

import com.example.boxes.loginfeature.domain.model.User
import javax.inject.Inject

data class LoginState(
    val mail : String ="",
    val name : String="",
    val password : String = "",
    val repeatedPassword : String =""
){
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
class MapperToDomainUser @Inject constructor() : LoginState.Mapper<User> {
    override fun map(mail: String, name: String, password: String,
                     repeatedPassword: String): User
    = User(mail, name, password, repeatedPassword)
}