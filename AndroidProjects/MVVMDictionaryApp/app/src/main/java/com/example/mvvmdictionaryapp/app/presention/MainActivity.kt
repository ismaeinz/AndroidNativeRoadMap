package com.example.mvvmdictionaryapp.app.presention

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmdictionaryapp.app.presention.events.MainUiEvents
import com.example.mvvmdictionaryapp.app.presention.state.MainState
import com.example.mvvmdictionaryapp.app.presention.theme.MVVMDictionaryAppTheme
import com.example.mvvmdictionaryapp.app.presention.viewmodels.MainViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMDictionaryAppTheme {
                BarColor()
                val mainViewModel = hiltViewModel<MainViewModel>()
                val mainState = mainViewModel.mainState.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(), topBar = {
                        OutlinedTextField(value = mainState.value.searchWord, onValueChange = {
                            mainViewModel.onEvent(
                                MainUiEvents.OnSearchWordChange(it)
                            )
                        }, trailingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .size(30.dp)
                                    .clickable {
                                        mainViewModel.onEvent(
                                            MainUiEvents.OnSearchClick
                                        )
                                    })
                        }, label = { Text("Search Here") })
                    }) { paddingValues ->
                    val padding = paddingValues
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = paddingValues.calculateTopPadding())
                    ) {
                        MainScreen(mainState)
                    }

                }
            }
        }
    }
}

@Composable
fun MainScreen(mainState: State<MainState>) {

}
@Composable
private fun BarColor() {
    val systemUiController = rememberSystemUiController()
    val color = MaterialTheme.colorScheme.background
    LaunchedEffect(color) {
        systemUiController.setSystemBarsColor(color)
    }
}

