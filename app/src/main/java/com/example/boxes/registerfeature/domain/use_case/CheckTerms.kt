package com.example.boxes.registerfeature.domain.use_case

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CheckTerms @Inject constructor() {

    fun execute(acceptedTerms: Boolean): CheckResult {
        if (!acceptedTerms) {
            return CheckResult(
                successful = false,
                errorMessage = "Please accept the terms"
            )
        }
        return CheckResult(
            successful = true,
            errorMessage = ""
        )
    }
}