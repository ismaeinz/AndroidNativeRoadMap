package com.example.posts.app.data

import com.example.posts.app.domain.model.PostsResponse
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getAllPosts(): PostsResponse
}