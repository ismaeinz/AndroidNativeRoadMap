package com.example.howtoshownotificationsinandroid.app

import android.Manifest
import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.NotificationCompat
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat

fun showNotification(context: Context) {
    val notificationId = 1
    val channelId = "my_channel_id"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "My Channel"
        val descriptionText = "This is my notification channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(
            channelId, name, importance).apply {
            description = descriptionText
        }
        // تسجيل القناة في النظام
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    // بناء الإشعار
    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info) // أيقونة صغيرة
        .setContentTitle("عنوان الإشعار")
        .setContentText("هذا هو نص الإشعار.") // نص الإشعار
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    // عرض الإشعار
    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notify(notificationId, builder.build())
    }

}