package com.example.retrofitcall.app.presention.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcall.app.data.remote.api.RetroFitInstance
import com.example.retrofitcall.app.data.remote.model.Post
import kotlinx.coroutines.launch

class PostsViewModels : ViewModel() {
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts


    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                _posts.value = RetroFitInstance.api.getAllPosts()
            } catch (e: Exception) {

            }
        }
    }
}