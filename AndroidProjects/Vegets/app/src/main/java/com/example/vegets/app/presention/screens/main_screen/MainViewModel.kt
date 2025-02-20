package com.example.vegets.app.presention.screens.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vegets.app.data.local.Product
import com.example.vegets.app.data.local.ProductDataBase
import com.example.vegets.app.data.remote.ApiServicesInstance
import com.example.vegets.app.presention.ProducApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val _state = mutableStateOf<List<Product>>(emptyList())
    val state: State<List<Product>> = _state
    private var dao = ProductDataBase.getDaoInstance(
        ProducApplication.getApplicationContext()
    )


    init {
        getAllProduct()
    }

    private fun getAllProduct() {
        viewModelScope.launch {
            _state.value = fetchData()

        }

    }

    private suspend fun fetchData(): List<Product> = withContext(Dispatchers.IO) {
        try {
            val getData = ApiServicesInstance.api.getAllProductsFromApi()
            dao.saveAllProductsToDb(getData)
            return@withContext getData

        } catch (e: Exception) {
            return@withContext dao.getAllProductsFromDb()
        }
    }
}
