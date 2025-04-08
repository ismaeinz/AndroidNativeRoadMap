package com.example.newsly.app.data.repositoryImpl

import com.example.newsly.app.data.remote.NewsApi
import com.example.newsly.app.domain.model.Article
import com.example.newsly.app.domain.repository.NewsRepository
import com.example.newsly.app.util.Resource
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {
    override suspend fun getTopHeading(category: String): Resource<List<Article>> {
        return try {
            val response = newsApi.getBreakingNews(category = category)
            Resource.Success(data = response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Catch Error Filled To Get Data From Api${e.message}")
        }
    }
}