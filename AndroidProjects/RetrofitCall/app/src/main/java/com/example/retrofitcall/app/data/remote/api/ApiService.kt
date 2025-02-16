package com.example.retrofitcall.app.data.remote.api

import com.example.retrofitcall.app.data.remote.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getAllPosts(): List<Post>
}