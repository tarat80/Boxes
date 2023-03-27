package com.example.boxes.registerfeature.domain

import com.example.boxes.loginfeature.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface RepositoryRegister {
    suspend fun register(email: String, password: String): Flow<Resource<Long>>
}
