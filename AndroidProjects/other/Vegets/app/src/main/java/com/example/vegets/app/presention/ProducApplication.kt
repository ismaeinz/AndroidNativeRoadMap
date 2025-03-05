package com.example.vegets.app.presention

import android.app.Application
import android.content.Context

class ProducApplication : Application() {
    init {
        application = this

    }

    companion object {
        private lateinit var application: ProducApplication
        fun getApplicationContext(): Context = application.applicationContext
    }
}