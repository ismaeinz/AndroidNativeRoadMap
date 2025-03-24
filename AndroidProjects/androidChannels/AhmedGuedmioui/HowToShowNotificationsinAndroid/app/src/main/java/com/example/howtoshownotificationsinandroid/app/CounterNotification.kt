package com.example.howtoshownotificationsinandroid.app

import android.content.Context
import androidx.core.app.NotificationCompat

class CounterNotification(
    private val context: Context
) {
    //    createNotification
    fun counterNotification() {
        val notification = NotificationCompat
            .Builder(context, CHANNEL_ID)
            .
    }

    companion object {
        const val CHANNEL_ID = "counter_channel"

    }
}