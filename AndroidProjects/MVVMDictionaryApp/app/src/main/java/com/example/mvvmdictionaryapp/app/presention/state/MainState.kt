package com.example.mvvmdictionaryapp.app.presention.state

import com.example.mvvmdictionaryapp.app.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",
    val wordItem: WordItem? = null
)