package com.example.vegets.app.data.remote

import com.example.vegets.app.data.local.Product
import retrofit2.http.GET

interface ApiServices {
    @GET(END_POINT)
    suspend fun getAllProductsFromApi(): List<Product>

    companion object {
        const val BASE_URL = "https://res.cloudinary.com/sivadass/raw/upload/v1535817394/json/"
        const val END_POINT = "products.json"
    }
}
