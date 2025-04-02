package com.example.newsroom.app.presention.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsroom.app.presention.viewmodels.NewsScreenViewModel

@Preview
@Composable
fun NewsScreen (viewModel: NewsScreenViewModel= hiltViewModel()) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy( 10.dp ),
        contentPadding = PaddingValues(10.dp)
    ) {
        items (viewModel.articles){article ->
            Text(text = article.title)
        }
    }
}