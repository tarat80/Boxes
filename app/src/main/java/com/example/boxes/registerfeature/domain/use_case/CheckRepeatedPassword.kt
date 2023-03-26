package com.example.boxes.registerfeature.domain.use_case

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CheckRepeatedPassword @Inject constructor() {

    fun execute(password: String, repeatedPassword: String): CheckResult {
        if(password != repeatedPassword) {
            return CheckResult(
                successful = false,
                errorMessage = "The passwords don't match"
            )
        }
        return CheckResult(
            successful = true,
            errorMessage = ""
        )
    }
}