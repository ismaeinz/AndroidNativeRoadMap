package com.example.day1.data.remote.api

import com.example.day1.data.remote.api.ApiServices.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServicesInstance {
    val api: ApiServices by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiServices::class.java)

    }
}