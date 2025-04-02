package com.example.newsroom.app.domain.repository

import com.example.newsroom.app.domain.model.Article
import com.example.newsroom.app.util.Result

interface NewsRepository {
    suspend fun getTopHeadLines(
        category: String
    ): Result<List<Article>>
}
