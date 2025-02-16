package com.example.retrofitvegets.app.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.retrofitvegets.app.data.remote.model.Product

class SharedViewModel : ViewModel() {
    var productPass by mutableStateOf<Product?>(null)
        private set

    fun getProduct(newProduct: Product) {
        productPass = newProduct

    }
}
