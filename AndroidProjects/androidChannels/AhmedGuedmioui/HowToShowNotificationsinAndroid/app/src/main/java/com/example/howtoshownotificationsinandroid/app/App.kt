package com.example.howtoshownotificationsinandroid.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val counterChannel = NotificationChannel(
                "counter_channel", "counter_channel", NotificationManager.IMPORTANCE_LOW
            )

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(counterChannel)

        }
    }
}
