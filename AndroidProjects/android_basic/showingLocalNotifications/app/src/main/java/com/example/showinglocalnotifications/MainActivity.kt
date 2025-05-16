package com.example.showinglocalnotifications

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.example.showinglocalnotifications.app.presention.WaterNotificationService

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestNotificationPermission()
        setContent {
            ShowAllNotification()
        }
    }

    //
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun requestNotificationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.POST_NOTIFICATIONS),
            100
        )

    }
}

@Composable
fun ShowAllNotification(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val waterNotificationService = WaterNotificationService(context)


        Column {
            Button(
                onClick = {
                    waterNotificationService.showBasicNotification()
                }) {
                Text(text = "Show basic notification")
            }

            Button(
                onClick = {
                    waterNotificationService.showExpandableNotification()
                }) {
                Text(text = "Show expandable with image notification")
            }

            Button(
                onClick = {
//                    waterNotificationService.showExpandableLongText()
                }) {
                Text(text = "Show expandable with text notification")
            }

            Button(
                onClick = {
//                    waterNotificationService.showInboxStyleNotification()
                }) {
                Text(text = "Show inbox-style notification")
            }

            Button(
                onClick = {
                    waterNotificationService.showNotificationGroup()
                }) {
                Text(text = "Show inbox-style notification group")
            }
        }
    }
}

