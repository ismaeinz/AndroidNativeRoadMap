package com.example.simpleapicallingwithretrofit.app.domain.model

data class Review(
    val rating: Int = 0, // 2
    val comment: String = "", // Very unhappy with my purchase!
    val date: String = "", // 2024-05-23T08:56:21.618Z
    val reviewerName: String = "", // John Doe
    val reviewerEmail: String = "" // john.doe@x.dummyjson.com
)