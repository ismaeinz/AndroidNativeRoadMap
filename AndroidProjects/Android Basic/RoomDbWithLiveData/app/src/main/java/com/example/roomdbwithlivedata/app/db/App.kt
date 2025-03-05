package com.example.roomdbwithlivedata.app.db

import android.app.Application
import android.content.Context


class App : Application() {
    init {
        application = this

    }

    //اجيب النستانس
    companion object {
        private lateinit var application: App
        fun getApplicationContext(): Context = application.applicationContext
    }
}