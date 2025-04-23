package com.example.todosmvvmeditable.app.presention.screens.addNote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todosmvvmeditable.app.presention.viewModels.AddViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavHostController, addViewModel: AddViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            "",
                            tint = Color.Blue.copy(.5f)
                        )
                    }
                },
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(text = "Add Note", color = Color.Blue.copy(.5f))
                    }
                },
                modifier = Modifier.background(Color.Gray),
            )
        },


        ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Write your Note Title ")
                },
                value = addViewModel.title,
                onValueChange = {
                    addViewModel.title = it
                },
                maxLines = 1,
                minLines = 1,
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(modifier = Modifier.fillMaxWidth(), label = {
                Text(text = "Write your Note Content  ")
            }, value = addViewModel.content,
                onValueChange = { addViewModel.content = it })
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(), onClick = {
                    addViewModel.addNote(

                    )
                }) {
                Text(text = "Add Note")
            }


        }
    }

}