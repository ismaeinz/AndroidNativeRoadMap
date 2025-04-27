package com.example.weatherapp.app.data.model

data class Condition(
    val text: String = "", // Partly cloudy
    val icon: String = "", // //cdn.weatherapi.com/weather/64x64/day/116.png
    val code: Int = 0 // 1003
)