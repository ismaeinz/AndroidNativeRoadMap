package com.example.services.app.counter

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun CounterScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                Intent(context, CounterServices::class.java)
                    .also {
                        it.action = CounterServices.CounterAction.START.name
                        context.startService(it)
                    }
            }
        ) {
            Text("Start Counter")
        }
        Spacer(modifier.height(20.dp))
        Button(onClick = {
            Intent(context, CounterServices::class.java)
                .also {
                    it.action = CounterServices.CounterAction.STOP.name
                    context.startService(it)

                }
        }) {
            Text("Stop Counter")
        }
    }

}