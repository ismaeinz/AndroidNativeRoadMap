package com.example.vegets.app.presention.screens.main_screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()
    val products = viewModel.state.value
    Log.i("DataFromApi", products.toString())
    LazyColumn {
        items(products) { product ->
            Column {
                Card(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = product.name)
                    AsyncImage(
                        model = product.image,
                        contentDescription = "Translated description of what the image contains"
                    )

                }
            }
        }
    }


}