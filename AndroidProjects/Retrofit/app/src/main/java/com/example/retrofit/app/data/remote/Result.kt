package com.example.retrofit.app.data.remote

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null,
    val isLoading: Boolean = true
) {
    class Success<T>(data: T?) : Result<T>(data)
    class Error<T>(data: T? = null, message: String) : Result<T>(data, message)
    class Loading<T>(data: T? = null, isLoading: Boolean) : Result<T>(data, isLoading = isLoading)

}