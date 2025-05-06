package com.example.dictionaryapp.app.data.repository

import android.app.Application
import com.example.dictionaryapp.app.data.api.DictionaryApiInterface
import com.example.dictionaryapp.app.domain.model.WordItem
import com.example.dictionaryapp.app.domain.repository.DictionaryRepository
import com.example.dictionaryapp.app.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    val dictionaryApiInterface: DictionaryApiInterface, private val application: Application
) : DictionaryRepository {
    override suspend fun getWordResult(word: String): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))
            val remoteWordResultDto = try {
                dictionaryApiInterface.getWordResult(word)
            } catch (e: Exception) {
                emit(Result.Error("Error"))
                return@flow
            }
            remoteWordResultDto.let { wordResultDto ->
                wordResultDto[0]?.let { wordItemDto ->
                    emit()
                }
            }
            emit(Result.Loading(false))


        }
    }


}