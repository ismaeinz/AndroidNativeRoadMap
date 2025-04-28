package com.example.simpleapicallingwithretrofit.app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInterfaceInstance {
    val apiInterface: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}