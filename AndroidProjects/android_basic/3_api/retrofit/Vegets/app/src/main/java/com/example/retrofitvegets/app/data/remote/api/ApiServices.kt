package com.example.retrofitvegets.app.data.remote.api

import com.example.retrofitvegets.app.data.remote.model.Product
import retrofit2.http.GET

interface ApiServices {
    @GET("products.json")
    suspend fun getAllProducts(): List<Product>

}
