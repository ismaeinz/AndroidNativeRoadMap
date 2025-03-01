package com.example.couritine.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class ScreenViewModel : ViewModel() {
     val intentChannel = Channel<ScreenIntent>()

    //    process
    private val _viewState = MutableStateFlow<ScreenState>(ScreenState.Idele)
    val state = _viewState.asStateFlow()

    //
     val number = 0
    private fun processIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect {
                when (it) {
                    ScreenIntent.AddNumber -> addNumber()
                }
            }
        }
    }


    private fun addNumber() {
        viewModelScope.launch {
            _viewState.value = try {
                ScreenState.Number(number + 1)
            } catch (e: Exception) {
                ScreenState.Error("Error")
            }
        }
    }


}