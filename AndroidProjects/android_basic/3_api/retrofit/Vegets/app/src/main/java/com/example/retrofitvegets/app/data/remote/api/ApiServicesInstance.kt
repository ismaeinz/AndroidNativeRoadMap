package com.example.retrofitvegets.app.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServicesInstance {
    val api: ApiServices by lazy {
        Retrofit.Builder()
            .baseUrl("https://res.cloudinary.com/sivadass/raw/upload/v1535817394/json/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiServices::class.java)
    }
}
