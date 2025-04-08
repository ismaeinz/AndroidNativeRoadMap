package com.example.newsly.app.domain.repository

import com.example.newsly.app.domain.model.Article
import com.example.newsly.app.util.Resource

interface NewsRepository {
    suspend fun getTopHeading(
        category: String
    ): Resource<List<Article>>
}