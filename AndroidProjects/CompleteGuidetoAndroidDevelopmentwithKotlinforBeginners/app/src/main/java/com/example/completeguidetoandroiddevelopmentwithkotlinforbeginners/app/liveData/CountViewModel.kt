package com.example.completeguidetoandroiddevelopmentwithkotlinforbeginners.app.liveData

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private val _timeleft = MutableLiveData(0)
    val timeLeft: LiveData<Int> = _timeleft

    private val timer: CountDownTimer? = null
    private val starTime = 0

    fun startCountDown(time: Int) {
        time?.cancel()
    }

}