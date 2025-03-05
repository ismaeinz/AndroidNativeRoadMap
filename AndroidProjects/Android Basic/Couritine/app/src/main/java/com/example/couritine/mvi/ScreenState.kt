package com.example.couritine.mvi

sealed class ScreenState {
    object Idele : ScreenState()
    data class Number(val number: Int) : ScreenState()
    data class Error(val error: String) : ScreenState()


}