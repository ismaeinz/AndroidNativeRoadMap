package com.example.hilt.app2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hilt.app2.navigation.HeaderNavigation

@Composable
fun OneQuoteApp(
    viewModel: MainActivityViewModel = viewModel()
) {
    val appState by viewModel.appState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {

        HeaderNavigation(
            navigation = appState.navigation,
            onClick = { viewModel.selectPage(it) }
        )

        // Page content
        val selectedPage = appState.navigation.selectedPage
        when (selectedPage.title) {
            "Page 1" -> {
                TempContent(itemColor = selectedPage.color)
            }

            "Page 2" -> {
                TempContent(selectedPage.color)
                TempContent(selectedPage.color)
            }

            "Page 3" -> {
                TempContent(selectedPage.color)
                TempContent(selectedPage.color)
                TempContent(selectedPage.color)
            }
        }
    }
}

@Composable
private fun TempContent(itemColor: Color) {
    Box(
        modifier = Modifier
            .padding(all = 32.dp)
            .height(16.dp)
            .fillMaxWidth()
            .background(
                color = itemColor,
                shape = MaterialTheme.shapes.medium
            )
    )
}