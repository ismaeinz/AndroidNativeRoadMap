package com.example.day1.presention.screens.main_screen

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
    val viewModel: MainScreenViewModel = viewModel()
    val countries = viewModel.state.value
    LazyColumn {
        items(countries) { country ->
            Column {
                Card(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = country.name.common)

                    Text(text = country.languages.ara)
                    AsyncImage(
                        model = country.flags.png,
                        contentDescription = "Translated description of what the image contains"
                    )

                }
            }
        }
    }
}