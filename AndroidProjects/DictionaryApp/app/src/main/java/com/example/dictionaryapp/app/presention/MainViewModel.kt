package com.example.dictionaryapp.app.presention

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryapp.app.domain.repository.DictionaryRepository
import com.example.dictionaryapp.app.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) : ViewModel() {
    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()
    private val searchJob: Job? = null
    fun onEvent(mainUiEvent: MainUiEvents) {
        when (mainUiEvent) {
            MainUiEvents.OnSearchClick -> {
                loadWordResult()
            }

            is MainUiEvents.OnSearchWordChange -> {
                _mainState.update {
                    it.copy(
                        searchWord = mainUiEvent.newWord.lowercase()
                    )
                }

            }

        }
    }

    private fun loadWordResult() {
        viewModelScope.launch(Dispatchers.IO) {
            dictionaryRepository.getWordResult(
                mainState.value.searchWord

            ).collect { result ->
                when (result) {
                    is Result.Error<*> -> Unit
                    is Result.Loading<*> -> {
                        _mainState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }

                    is Result.Success<*> -> {
                        result.data?.let { wordItem ->
                            _mainState.update {
                                it.copy(
                                    wordItem = wordItem
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
