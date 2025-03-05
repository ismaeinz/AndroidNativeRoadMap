package com.example.hilt.app.data

import retrofit2.http.GET

interface SomeApi {
    @GET("same-route")
    suspend fun callApi()
}