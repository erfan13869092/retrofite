package com.example.apiretrofite.util

sealed class StateResponse<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : StateResponse<T>(data)
    class Loading<T> : StateResponse<T>()
    class Error<T>(message: String) : StateResponse<T>(message = message)
}