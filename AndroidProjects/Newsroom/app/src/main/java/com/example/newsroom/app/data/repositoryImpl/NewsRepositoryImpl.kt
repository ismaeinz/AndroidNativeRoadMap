package com.example.newsroom.app.data.repositoryImpl

import com.example.newsroom.app.data.remote.NewsApi
import com.example.newsroom.app.domain.model.Article
import com.example.newsroom.app.domain.repository.NewsRepository
import com.example.newsroom.app.util.Result
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : NewsRepository{
    override suspend fun getTopHeadLines(category: String): Result<List<Article>> {
return try {
val response=newsApi.getBreakingNews(category=category)
    Result.Success(response.articles)
}catch (e: Exception){
    Result.Error(message = "Failed To Load Data " +
            "? check Your Internet Connection ... ")
}
    }
}
//