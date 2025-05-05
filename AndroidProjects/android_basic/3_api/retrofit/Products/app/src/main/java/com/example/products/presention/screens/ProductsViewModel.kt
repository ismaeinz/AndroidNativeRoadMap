package com.example.products.presention.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products.app.data.remote.ProductsRepository
import com.example.products.app.data.remote.Result
import com.example.products.app.data.remote.model.Product
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
//
    private val productsRepository: ProductsRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()
    private var _showErrorToastChannel = Channel<Boolean>()
    val showErrorToast = _showErrorToastChannel.receiveAsFlow()

    init {
        Log.d("Mux", products.value.toString())
        fetchDataFromApi()

    }

    private fun fetchDataFromApi() {
        viewModelScope.launch {
            productsRepository.getProductsList().collectLatest { result ->
                when (result) {
                    is Result.Error<*> -> {
                        _showErrorToastChannel.send(true)
                    }

                    is Result.Success<*> -> {
                        result.data?.let { products ->
                            _products.update { products }
                        }
                    }
                }
            }
        }
    }
}