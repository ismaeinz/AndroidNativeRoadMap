package com.example.movieapp.app.movie.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("page")
    val page: Int? = null, // 1
    @SerialName("results")
    val results: List<Result?>? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null, // 49014
    @SerialName("total_results")
    val totalResults: Int? = null // 980262
)