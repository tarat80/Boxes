package com.example.boxes.loginfeature.domain

import com.example.boxes.loginfeature.domain.model.User

interface LoginRepository {
    suspend fun checkLogData()

    suspend fun register(user: User)
}