package com.example.mvvmdictionaryapp.app.presentiondata

class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",

    val wordItem: WordItem? = null
)