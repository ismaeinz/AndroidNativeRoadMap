package com.example.todosmvvmeditable.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todosmvvmeditable.app.navigation.AppNavigation
import com.example.todosmvvmeditable.app.presention.theme.TodosMvvmEditableTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodosMvvmEditableTheme {
                navController = rememberNavController()
                AppNavigation(navController = navController)
            }

        }
    }
}