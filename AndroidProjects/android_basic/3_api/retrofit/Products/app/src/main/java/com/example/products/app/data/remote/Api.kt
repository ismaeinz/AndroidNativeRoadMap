package com.example.products.app.data.remote

import com.example.products.app.data.remote.model.Products
import retrofit2.http.GET

interface Api {
    @GET("products")
    suspend fun getProductsList(): Products
}