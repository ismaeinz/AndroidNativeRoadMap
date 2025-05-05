package com.example.products

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products.app.data.ProductsRepositoryImpl
import com.example.products.app.data.remote.RetrofitInstance
import com.example.products.presention.screens.ProductScreen
import com.example.products.presention.screens.ProductsViewModel
import com.example.products.presention.theme.ProductsTheme

class MainActivity : ComponentActivity() {
    private val viewModel by
    viewModels<ProductsViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ProductsViewModel(ProductsRepositoryImpl(RetrofitInstance.api))
                            as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductsTheme {
                val productList = viewModel.products.collectAsState().value
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductScreen(
                        modifier = Modifier.padding(innerPadding),
                        productList
                    )
                }
            }
        }
    }
}
