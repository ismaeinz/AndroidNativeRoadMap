package com.example.newsly.app.data.remote

import com.example.newsly.app.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

//Api Arch
interface NewsApi {
    @GET(END_POINT)
    suspend fun getBreakingNews(
        @Query(PARAMETER_CATEGORY) category: String,
        @Query(PARAMETER_COUNTRY) country: String = "us",
        @Query("apikey") apiKey: String = PARAMETER_API_KEY,
    ): NewsResponse

    companion object {
        const val BASE_URL: String = "https://newsapi.org/v2/"
        const val END_POINT: String = "top-headlines"
        const val PARAMETER_CATEGORY: String = "category"
        const val PARAMETER_COUNTRY: String = "country"
        const val PARAMETER_API_KEY: String = "ba330e02908548608ed000999a71ceb1"


    }
}