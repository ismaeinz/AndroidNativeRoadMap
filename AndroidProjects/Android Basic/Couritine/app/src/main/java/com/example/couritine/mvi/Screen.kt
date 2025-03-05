package com.example.couritine.mvi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun Screen(
    modifier: Modifier = Modifier,
) {
    val viewModel: ScreenViewModel = viewModel<ScreenViewModel>()


//send
//    render
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = viewModel.number.toString())
        Spacer(modifier = modifier.size(20.dp))
        Button(onClick = {
            GlobalScope.launch {
                viewModel.intentChannel.send(ScreenIntent.AddNumber)
            }
        }) {
            Text(text = "Send intent to vm")

        }

    }

}