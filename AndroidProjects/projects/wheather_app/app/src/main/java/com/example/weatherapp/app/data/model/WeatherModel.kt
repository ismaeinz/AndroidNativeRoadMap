package com.example.weatherapp.app.data.model

data class WeatherModel(
    val location: Location = Location(),
    val current: Current = Current()
)