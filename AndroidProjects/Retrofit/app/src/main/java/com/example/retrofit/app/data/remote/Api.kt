package com.example.retrofit.app.data.remote

import com.example.retrofit.app.data.remote.model.Products
import retrofit2.http.GET

interface Api {

    @GET("products")
    suspend fun getProductsList(

    ): Products

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}