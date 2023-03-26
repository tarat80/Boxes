package com.example.boxes.loginfeature.domain.use_case

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RetrieveID @Inject constructor(
  //  private val repositoryLogin: RepositoryLogin
) {
    fun execute(
        email: String,
        password: String
    ): CheckResult = CheckResult(true,"tenh",10)
}