package com.example.boxes.registerfeature.domain.use_case

import com.example.boxes.loginfeature.domain.RepositoryLogin
import com.example.boxes.registerfeature.domain.RepositoryRegister
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RetrieveID @Inject constructor(
    private val repositoryRegister : RepositoryRegister
){
    fun execute(
        email: String,
        password: String
    ){

    }
}