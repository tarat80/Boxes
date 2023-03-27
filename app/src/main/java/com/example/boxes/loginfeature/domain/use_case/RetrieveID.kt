package com.example.boxes.loginfeature.domain.use_case

import com.example.boxes.loginfeature.domain.RepositoryLogin
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RetrieveID @Inject constructor(
    private val repositoryLogin: RepositoryLogin
) {
    suspend fun execute(
        email: String,
        password: String
    )  = repositoryLogin.login(email, password)
}