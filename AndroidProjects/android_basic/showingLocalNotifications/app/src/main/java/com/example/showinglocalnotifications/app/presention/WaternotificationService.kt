package com.example.showinglocalnotifications.app.presention

//noinspection SuspiciousImport
import android.R
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class WaterNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun showNotification() {
        val notification =
            NotificationCompat.Builder(context, "water_remainder")
                .setContentTitle("Water ")
                .setSmallIcon(R.drawable.ic_menu_week)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setAutoCancel(true)
                .build()
        notificationManager.notify(
            Random.nextInt(), notification
        )
    }

    fun showExpandableNotification() {
        val image =
            context.bitmapFromResource(R.drawable.ic_menu_week)

        val notification =
            NotificationCompat.Builder(context, "water_remainder")
                .setContentTitle("Water ")
                .setContentText("text of notification")
                .setSmallIcon(R.drawable.ic_menu_week)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("Very Big")
                )
                .setAutoCancel(true)
                .build()
        notificationManager.notify(
            Random.nextInt(), notification
        )
    }

    fun showBasicNotification() {
        val notification =
            NotificationCompat.Builder(context, "water_remainder")
                .setContentTitle("Water ")
                .setSmallIcon(R.drawable.ic_menu_week)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setAutoCancel(true)
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .addLine("Line 1")
                        .addLine("Line 1")
                        .addLine("Line 1")
                        .addLine("Line 1")
                        .addLine("Line 1")
                        .addLine("Line 1")
                        .addLine("Line 1")
                )
                .build()
        notificationManager.notify(
            Random.nextInt(), notification
        )
    }

    fun showNotificationGroup() {
        val groupId = "water_group"
        val summeryId = 0
        val notification1 =
            NotificationCompat.Builder(context, "water_remainder")
                .setContentTitle("Water ")
                .setContentText("text of notification")
                .setSmallIcon(R.drawable.ic_menu_week)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setStyle(NotificationCompat.InboxStyle().addLine("Line 1"))
                .setAutoCancel(true)
                .setGroup(groupId)
                .build()
//
        val notification2 =
            NotificationCompat.Builder(context, "water_remainder")
                .setContentTitle("Water ")
                .setContentText("text of notification")
                .setSmallIcon(R.drawable.ic_menu_week)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .addLine("Line 1")
                        .addLine("Line 1")

                )
                .setAutoCancel(true)
                .setGroup(groupId)
                .build()

//
        val summeryNotification =
            NotificationCompat.Builder(context, "water_remainder")
                .setContentTitle("Water ")
                .setContentText("text of notification")
                .setSmallIcon(R.drawable.ic_menu_week)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .setSummaryText(" summeryNotification")
                        .setBigContentTitle("setBigContentTitle")

                )
                .setAutoCancel(true)
                .setGroup(groupId)
                .setGroupSummary(true)
                .build()

        notificationManager.notify(
            Random.nextInt(), notification1
        )

        notificationManager.notify(
            Random.nextInt(), notification2
        )

        notificationManager.notify(
            Random.nextInt(), summeryNotification
        )
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId: Int
    ): Bitmap = BitmapFactory.decodeResource(resources, resId)
}