package com.example.retrofitvegets.app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retrofitvegets.app.presention.screens.ProductScreen
import com.example.retrofitvegets.app.presention.screens.ProductsScreen

@Composable
fun App() {
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.ProductsScreen.route) {
        composable(route = Routes.ProductsScreen.route) {
            ProductsScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable(route = Routes.ProductScreen.route) {
            ProductScreen(sharedViewModel)
        }
    }

}