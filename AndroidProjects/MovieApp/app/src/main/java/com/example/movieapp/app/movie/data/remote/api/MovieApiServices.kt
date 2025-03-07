package com.example.movieapp.app.movie.data.remote.api

import com.example.movieapp.app.movie.data.remote.models.MovieDto
import com.example.movieapp.app.utils.K
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiServices {
    @GET(K.MOVIE_ENDPOINT)
    suspend fun fetchDiscoverMovie(
        @Query("api_key") apiKey: String = "aee2e249581b1ef7ed2cb17f5629ef39",
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto

    @GET(K.TRENDING_MOVIE_ENDPOINT)
    suspend fun fetchTrendingMovie(
        @Query("api_key") apiKey: String = "aee2e249581b1ef7ed2cb17f5629ef39",
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto


}
