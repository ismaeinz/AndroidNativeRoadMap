package com.example.simpleapicallingwithretrofit.app.presention.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleapicallingwithretrofit.app.data.ApiInterfaceInstance
import com.example.simpleapicallingwithretrofit.app.domain.model.ProductX
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val _products = mutableStateOf<List<ProductX>>(emptyList())
    private val products = _products


    init {
        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        viewModelScope.launch {
            _products.value = ApiInterfaceInstance.apiInterface.getProducts()
        }
    }
}