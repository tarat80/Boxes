package com.example.boxes.registerfeature.domain.use_case

import com.example.boxes.loginfeature.domain.model.Resource
import com.example.boxes.registerfeature.domain.RepositoryRegister
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class RetrieveID @Inject constructor(
    private val repositoryRegister : RepositoryRegister
){
    suspend fun execute(
        email: String,
        password: String
    ) : Flow<Resource<Long>> = repositoryRegister.register(email, password)
}