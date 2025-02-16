package com.example.retrofitvegets.app.presention.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.retrofitvegets.app.navigation.SharedViewModel


@Composable
fun ProductScreen(sharedViewModel: SharedViewModel) {
    val product = sharedViewModel.productPass

    Card(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = product?.name.toString())
                Text(text = product?.category.toString())
            }

            AsyncImage(
                model = product?.image,
                contentDescription = "Translated description of what the image contains",
            )
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "price is :  ${product?.price.toString()} LE  ")
            }
        }

    }
}
