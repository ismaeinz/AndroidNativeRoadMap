package com.example.dictionaryapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dictionaryapp.app.presention.theme.DictionaryAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DictionaryAppTheme {

            }
        }

    }

    @Composable
    fun BarColor(modifier: Modifier = Modifier) {

    }
}
//https://youtu.be/LKxSlq_jMd8?t=2143