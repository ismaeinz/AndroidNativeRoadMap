package com.example.howtoshownotificationsinandroid.app

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.howtoshownotificationsinandroid.R

@Composable
fun NotificationScreen(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.explainingNotifications))
        Button(onClick = {
            showNotification(context)
        }) {
            Text("showNotification")
        }
        Button(onClick = {
            showNotificationWithIntent(context)
        }) {
            Text("showNotificationWithIntent")
        }
    }
}