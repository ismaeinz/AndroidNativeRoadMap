package com.example.posts.app.prsention.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.app.data.ApiInstance
import com.example.posts.app.domain.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchDataFromApi()
        Log.d("posts", posts.toString())

    }

    private fun fetchDataFromApi() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = ApiInstance.api.getAllPosts()
                _posts.value = response.posts
            } catch (e: Exception) {
                _errorMessage.value = e.localizedMessage

            } finally {
                _isLoading.value = false
            }
        }
    }
}