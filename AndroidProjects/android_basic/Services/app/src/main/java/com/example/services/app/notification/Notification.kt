package com.example.services.app.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val counterChannel = NotificationChannel(
            "counter_channel",
            "counter_channel",
            NotificationManager.IMPORTANCE_LOW
        )
        val notificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(counterChannel)
    }
}

