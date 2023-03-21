package com.example.boxes.loginfeature.domain

interface LoginRepository {
    suspend fun checkLogData()
}