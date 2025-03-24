package com.example.mvvmdictionaryapp.app.domain.repository

import com.example.mvvmdictionaryapp.app.domain.model.WordItem
import com.example.mvvmdictionaryapp.app.util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>>

} 