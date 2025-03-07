package com.example.movieapp.app.movie.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("adult")
    val adult: Boolean? = null, // false
    @SerialName("backdrop_path")
    val backdropPath: String? = null, // /9nhjGaFLKtddDPtPaX5EmKqsWdH.jpg
    @SerialName("genre_ids")
    val genreIds: List<Int?>? = null,
    @SerialName("id")
    val id: Int? = null, // 950396
    @SerialName("original_language")
    val originalLanguage: String? = null, // en
    @SerialName("original_title")
    val originalTitle: String? = null, // The Gorge
    @SerialName("overview")
    val overview: String? = null, // Two highly trained operatives grow close from a distance after being sent to guard opposite sides of a mysterious gorge. When an evil below emerges, they must work together to survive what lies within.
    @SerialName("popularity")
    val popularity: Double? = null, // 2192.325
    @SerialName("poster_path")
    val posterPath: String? = null, // /7iMBZzVZtG0oBug4TfqDb9ZxAOa.jpg
    @SerialName("release_date")
    val releaseDate: String? = null, // 2025-02-13
    @SerialName("title")
    val title: String? = null, // The Gorge
    @SerialName("video")
    val video: Boolean? = null, // false
    @SerialName("vote_average")
    val voteAverage: Double? = null, // 7.765
    @SerialName("vote_count")
    val voteCount: Int? = null // 1654
)