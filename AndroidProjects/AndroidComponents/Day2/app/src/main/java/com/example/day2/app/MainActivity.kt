package com.example.day2.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.day2.app.presention.screens.MainScreen
import com.example.day2.app.presention.viewmodel.DatabaseViewmodel

class MainActivity : ComponentActivity() {
    private lateinit var databaseViewmodel: DatabaseViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        databaseViewmodel = ViewModelProvider(this)[DatabaseViewmodel::class.java]
        setContent {
            MainScreen(databaseViewmodel)
        }
    }
}