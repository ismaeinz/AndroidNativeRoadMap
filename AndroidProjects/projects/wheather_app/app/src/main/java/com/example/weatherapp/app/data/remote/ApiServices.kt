package com.example.weatherapp.app.data.remote

import com.example.weatherapp.app.data.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("2c737010a5ef434eb0883741250201") apikey: String, @Query("q") city: String
    ): Response<WeatherModel>


}

