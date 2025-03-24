package com.example.howtoshownotificationsinandroid.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.howtoshownotificationsinandroid.app.presention.theme.HowToShowNotificationsinAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HowToShowNotificationsinAndroidTheme {
            }
        }
    }
}