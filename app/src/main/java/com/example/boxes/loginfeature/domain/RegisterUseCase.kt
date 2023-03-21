package com.example.boxes.loginfeature.domain

import com.example.boxes.loginfeature.domain.model.User
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend fun execute(user: User){
        loginRepository.register(user)
    }
}