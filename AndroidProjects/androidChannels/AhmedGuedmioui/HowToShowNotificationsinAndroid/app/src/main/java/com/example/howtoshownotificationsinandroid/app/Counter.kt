package com.example.howtoshownotificationsinandroid.app

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class Counter {
    private var counterValue: Int = 0
    private var isRunning: Boolean = true


    fun start() = flow {
        isRunning = true
        while (isRunning) {
            emit(counterValue)
            delay(1000)
            counterValue++
        }
    }

    fun stop() {
        isRunning = false
        counterValue = 0
    }

}