package com.example.retrofitvegets.app.presention.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitvegets.app.data.remote.api.ApiServicesInstance
import com.example.retrofitvegets.app.data.remote.model.Product
import kotlinx.coroutines.launch

class VegetsVm : ViewModel() {
    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {

        viewModelScope.launch {
            try {
                val repo = ApiServicesInstance.api.getAllProducts()
                _products.value = repo

            } catch (e: Exception) {

            }
        }
    }
}
