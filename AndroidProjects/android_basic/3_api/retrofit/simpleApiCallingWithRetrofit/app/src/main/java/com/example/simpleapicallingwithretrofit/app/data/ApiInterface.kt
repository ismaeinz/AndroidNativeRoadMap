package com.example.simpleapicallingwithretrofit.app.data

import com.example.simpleapicallingwithretrofit.app.domain.model.ProductX
import retrofit2.http.GET

interface ApiInterface {
    @GET("products.json")
    suspend fun getProducts(): List<ProductX>
}