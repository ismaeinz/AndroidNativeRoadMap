package com.example.retrofitcall.app.presention.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.retrofitcall.app.data.remote.model.Post

@Composable
fun PostsScreen(
    modifier: Modifier = Modifier, viewModel: PostsViewModels = PostsViewModels()
) {
    val posts by viewModel.posts

    if (posts.isEmpty()) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(posts) { post -> PostCard(post) }
        }
    }

}

@Composable
fun PostCard(post: Post) {
    Column {
        Text(post.id.toString())
        Text(post.title.toString())
        Text(post.body.toString())

    }

}