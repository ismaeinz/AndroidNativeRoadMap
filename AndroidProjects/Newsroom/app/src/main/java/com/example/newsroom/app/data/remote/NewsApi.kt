package com.example.newsroom.app.data.remote

import com.example.newsroom.app.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi{

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String="us",
        @Query("apiKey") apiKey: String=API_KEY,
        ): NewsResponse
    companion object{
        const val BASE_URL="https://newsapi.org/v2/"
        const val API_KEY="ba330e02908548608ed000999a71ceb1"

    }
}