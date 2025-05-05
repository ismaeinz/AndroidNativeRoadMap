package com.example.products.app.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val api: Api = Retrofit.Builder().baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(Api::class.java)

}