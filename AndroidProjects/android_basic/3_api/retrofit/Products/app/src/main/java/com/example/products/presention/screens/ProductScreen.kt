package com.example.products.presention.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.products.app.data.remote.model.Product

@Composable
fun ProductScreen(modifier: Modifier = Modifier, productList: List<Product>) {
    if (productList.isEmpty()) {
        CircularProgressIndicator()
    } else {
        Text("List")
    }

}