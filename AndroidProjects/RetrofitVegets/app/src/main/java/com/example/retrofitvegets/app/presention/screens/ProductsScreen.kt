package com.example.retrofitvegets.app.presention.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.retrofitvegets.app.data.remote.model.Product
import com.example.retrofitvegets.app.navigation.Routes
import com.example.retrofitvegets.app.navigation.SharedViewModel

@Composable
fun ProductsScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    val viewModel: VegetsVm = viewModel()
    val products = viewModel.products.value
    if (products.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()

        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "Buy Now",
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
//            columns = GridCells.Fixed(2),

            ) {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        navController = navController,
                        sharedViewModel = sharedViewModel
                    )
                }


            }
        }
    }
}

@Composable
fun ProductItem(product: Product, navController: NavController, sharedViewModel: SharedViewModel) {
    Column {
        Card(modifier = Modifier
            .padding(10.dp)
            .clickable {
                val product = product
                sharedViewModel.getProduct(newProduct = product)
                navController.navigate(route = Routes.ProductScreen.route)
            }) {

            Text(text = product.name)
            AsyncImage(
                model = product.image,
                contentDescription = "Translated description of what the image contains"
            )

        }
    }
}
