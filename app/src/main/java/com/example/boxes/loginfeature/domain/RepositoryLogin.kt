package com.example.boxes.loginfeature.domain

import com.example.boxes.loginfeature.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface RepositoryLogin {

    suspend fun login(email: String, password: String ) : Flow<Resource<Long>>
}