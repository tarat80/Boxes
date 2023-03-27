package com.example.boxes.loginfeature.domain.model

sealed class Resource<T>(val data: T, val message: String ="") {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T): Resource<T>(data, message)
}
