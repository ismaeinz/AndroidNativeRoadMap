package com.example.weatherapp.app.data.model

data class Location(
    val name: String = "", // London
    val region: String = "", // City of London, Greater London
    val country: String = "", // United Kingdom
    val lat: Double = 0.0, // 51.5171
    val lon: Double = 0.0, // -0.1062
    val tzId: String = "", // Europe/London
    val localtimeEpoch: Int = 0, // 1745673252
    val localtime: String = "" // 2025-04-26 14:14
)