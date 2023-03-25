package com.example.boxes.loginfeature.domain.use_case

import android.util.Patterns
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CheckEmail @Inject constructor() {

    fun execute(email: String): CheckResult {
        if(email.isBlank()) {
            return CheckResult(
                successful = false,
                errorMessage = "The email can't be blank"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return CheckResult(
                successful = false,
                errorMessage = "That's not a valid email"
            )
        }
        return CheckResult(
            successful = true
        )
    }
}