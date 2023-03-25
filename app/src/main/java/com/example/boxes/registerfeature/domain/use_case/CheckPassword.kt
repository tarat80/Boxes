package com.example.boxes.registerfeature.domain.use_case

import com.example.boxes.loginfeature.domain.use_case.CheckResult
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CheckPassword @Inject constructor(){

    fun execute(password: String): CheckResult {
        if(password.length < 8) {
            return CheckResult(
                successful = false,
                errorMessage = "The password needs to consist of at least 8 characters"
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if(!containsLettersAndDigits) {
            return CheckResult(
                successful = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )
        }
        return CheckResult(
            successful = true
        )
    }
}