package com.example.dictionaryapp.app.presention

import com.example.dictionaryapp.app.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",
    val wordItem: WordItem? = null
)
