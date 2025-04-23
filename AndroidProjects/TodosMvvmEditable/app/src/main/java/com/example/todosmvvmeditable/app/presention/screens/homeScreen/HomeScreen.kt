package com.example.todosmvvmeditable.app.presention.screens.homeScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todosmvvmeditable.app.navigation.Screens
import com.example.todosmvvmeditable.app.presention.viewModels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val notes = viewModel.notes.collectAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                { Text(text = "My Notes") })
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screens.AddScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(notes.value) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(1.dp, color = Color.Gray)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "")
                            Spacer(modifier = Modifier.weight(1f))

                            IconButton(onClick = {
                                navController.navigate(
                                    Screens.UpdateScreen.getById(it.id)
                                )
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Edit, "",
                                    tint = Color.Blue.copy(.5f)
                                )
                            }
                            IconButton(onClick = {
                                viewModel.deleteNote(note = it)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    "",
                                    tint = Color.Red.copy(.5f)


                                )
                            }
                        }
                        Text(text = it.title)
                        Text(text = it.content)

                    }
                }
            }
        }
    }
}