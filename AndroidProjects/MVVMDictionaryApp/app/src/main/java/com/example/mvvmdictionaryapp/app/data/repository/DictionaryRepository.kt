package com.example.mvvmdictionaryapp.app.data.repository

import android.app.Application
import coil.network.HttpException
import com.example.mvvmdictionaryapp.app.data.mapper.toWordItem
import com.example.mvvmdictionaryapp.app.data.remote.api.DictionaryApi
import com.example.mvvmdictionaryapp.app.domain.model.WordItem
import com.example.mvvmdictionaryapp.app.domain.repository.DictionaryRepository
import com.example.mvvmdictionaryapp.app.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
) : DictionaryRepository {
    override suspend fun getWordResult(word: String): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))
            val remoteResultDto = try {
                dictionaryApi.getWordResult(word)
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error("Cant Get Result"))
                emit(Result.Loading(false))
                return@flow

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error("Cant Get Result"))
                emit(Result.Loading(false))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error("Cant Get Result"))
                emit(Result.Loading(false))
                return@flow
            }
            remoteResultDto?.let { wordResultDto ->
                wordResultDto[0]?.let { wordItemDto ->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                    return@flow

                }
            }
            emit(Result.Error("Cant Get Result"))
            emit(Result.Loading(false))

        }
    }

}