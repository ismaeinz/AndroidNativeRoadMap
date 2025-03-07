package com.example.uris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uri = "android.resource://$packageName/drawable/icon".toUri()
        val icon = contentResolver.openInputStream(uri)?.use {
            it.readBytes()
        }
        println("iconSize ${icon?.size}")
        enableEdgeToEdge()
        setContent {
        }
    }
}