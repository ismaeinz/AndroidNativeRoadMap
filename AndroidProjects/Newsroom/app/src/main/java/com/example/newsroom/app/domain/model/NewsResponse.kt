package com.example.newsroom.app.domain.model
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)