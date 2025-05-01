package com.example.posts.app.prsention.screens.home

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen() {
    val postViewModel: HomeViewModel = viewModel()
    val posts = postViewModel.posts.value
    Log.d("postsSize", posts.toString())
    LazyColumn {
//        items(posts.) { post ->
//            Text(post)
//        }
    }
}