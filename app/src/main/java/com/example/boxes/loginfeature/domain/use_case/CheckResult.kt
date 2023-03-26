package com.example.boxes.loginfeature.domain.use_case

data class CheckResult(
    val successful: Boolean,
    val errorMessage: String = "",
    val id : Int = -1
)
