package com.example.day1.data.remote.api

import com.example.day1.data.remote.responed.ResponedItem
import retrofit2.http.GET

interface ApiServices {
    @GET(END_POINT)
    suspend fun getAllCountries(): List<ResponedItem>

    companion object {
        const val BASE_URL = "https://restcountries.com/v3.1/"
        const val END_POINT = "all"
    }
}
