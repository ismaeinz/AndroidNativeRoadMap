package com.example.weatherapp.app.data.model

data class Current(
    val lastUpdatedEpoch: Int = 0, // 1745672400
    val lastUpdated: String = "", // 2025-04-26 14:00
    val tempC: Int = 0, // 17
    val tempF: Double = 0.0, // 62.6
    val isDay: Int = 0, // 1
    val condition: Condition = Condition(),
    val windMph: Double = 0.0, // 7.4
    val windKph: Double = 0.0, // 11.9
    val windDegree: Int = 0, // 91
    val windDir: String = "", // E
    val pressureMb: Int = 0, // 1022
    val pressureIn: Double = 0.0, // 30.18
    val precipMm: Double = 0.0, // 0.01
    val precipIn: Int = 0, // 0
    val humidity: Int = 0, // 55
    val cloud: Int = 0, // 50
    val feelslikeC: Int = 0, // 17
    val feelslikeF: Double = 0.0, // 62.6
    val windchillC: Double = 0.0, // 16.4
    val windchillF: Double = 0.0, // 61.5
    val heatindexC: Double = 0.0, // 16.4
    val heatindexF: Double = 0.0, // 61.5
    val dewpointC: Int = 0, // 7
    val dewpointF: Double = 0.0, // 44.5
    val visKm: Int = 0, // 10
    val visMiles: Int = 0, // 6
    val uv: Double = 0.0, // 4.4
    val gustMph: Double = 0.0, // 8.5
    val gustKph: Double = 0.0 // 13.7
)