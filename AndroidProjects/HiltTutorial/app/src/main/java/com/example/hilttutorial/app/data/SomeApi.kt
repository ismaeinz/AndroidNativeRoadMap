package com.example.hilttutorial.app.data

import retrofit2.http.GET

interface SomeApi {

    @GET("some-route")
    suspend fun callApi()
}