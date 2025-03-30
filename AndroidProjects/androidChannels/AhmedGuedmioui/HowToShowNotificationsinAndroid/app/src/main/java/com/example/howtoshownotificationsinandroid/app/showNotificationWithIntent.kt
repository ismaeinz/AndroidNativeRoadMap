package com.example.howtoshownotificationsinandroid.app
import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

fun showNotificationWithIntent(context: Context) {
    val channelId = "my_channel_id"
    val notificationId = 1

    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context, 0, intent, PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_notification_clear_all)
        .setContentTitle("عنوان الإشعار")
        .setContentText("اضغط لفتح التطبيق")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent) // ربط الإشعار بالنقر
        .setAutoCancel(true) // إزالة الإشعار عند النقر

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
