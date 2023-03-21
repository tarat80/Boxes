package com.example.boxes.loginfeature.domain

import com.example.boxes.loginfeature.domain.model.User
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend fun execute(user: User){

    }
}