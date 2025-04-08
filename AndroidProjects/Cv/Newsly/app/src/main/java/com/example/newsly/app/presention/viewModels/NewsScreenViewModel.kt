package com.example.newsly.app.presention.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsly.app.domain.model.Article
import com.example.newsly.app.domain.repository.NewsRepository
import com.example.newsly.app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsScreenViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    var articles by mutableStateOf<List<Article>>(emptyList())

    init {
        getNewsArticles("general")
    }

    private fun getNewsArticles(category: String) {
        viewModelScope.launch {
            val result = newsRepository.getTopHeading(category = category)
            when (result) {
                is Resource.Error<*> -> TODO()
                is Resource.Success<*> -> {
                    articles = result.data ?: emptyList()
                }
            }
        }
    }

}