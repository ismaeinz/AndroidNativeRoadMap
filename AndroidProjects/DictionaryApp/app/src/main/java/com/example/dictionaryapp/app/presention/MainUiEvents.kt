package com.example.dictionaryapp.app.presention

sealed class MainUiEvents {
    data class OnSearchWordChange(val newWord: String) : MainUiEvents()
    object OnSearchClick : MainUiEvents()
}