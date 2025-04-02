package com.example.newsroom.app.presention.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsroom.app.data.repositoryImpl.NewsRepositoryImpl
import com.example.newsroom.app.domain.model.Article
import com.example.newsroom.app.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsScreenViewModel @Inject
constructor(private val  newsRepository: NewsRepositoryImpl)
    : ViewModel() {
    var articles by mutableStateOf<List<Article>>(emptyList())


    init {
        getNewsArticle(category = "general")
    }
    private fun getNewsArticle(category: String){
        viewModelScope.launch {
            val result=newsRepository.getTopHeadLines(category=category)
            when(result){
                is Result.Success<*> -> {
                    articles=result.data?:emptyList()
                }
                is Result.Error<*> -> {
                }
            }
        }
    }

}