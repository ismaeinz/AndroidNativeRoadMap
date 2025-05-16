package com.example.showinglocalnotifications.app.presention

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.showinglocalnotifications.R


class App : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()


        val id: String = "water_remainder"
        val name: String = getString(R.string.water_remainder_channel)
        val importance: Int = NotificationManager.IMPORTANCE_LOW

        val notificationChannel = NotificationChannel(
            id, name, importance
        )
        notificationChannel.description = "A Channel"
        val notificationManger =
            getSystemService(NOTIFICATION_SERVICE)
                    as NotificationManager
        notificationManger.createNotificationChannel(notificationChannel)

    }
}