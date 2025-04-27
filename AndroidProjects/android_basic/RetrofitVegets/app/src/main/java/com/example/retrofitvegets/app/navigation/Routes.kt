package com.example.retrofitvegets.app.navigation

sealed class Routes(val route: String) {


    object ProductsScreen : Routes(route = "products-screen")
    object ProductScreen : Routes(route = "product-screen")


}