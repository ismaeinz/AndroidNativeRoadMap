package com.example.day2.app.presention.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.day2.R
import com.example.day2.app.data.local.DatabaseModel
import com.example.day2.app.presention.viewmodel.DatabaseViewmodel
import java.util.Calendar

@Composable
fun MainScreen(viewModel: DatabaseViewmodel) {
    val context = LocalContext.current
    val taskList by viewModel.taskList.observeAsState(emptyList())
    var isAddDialogOpen by rememberSaveable { mutableStateOf(false) }
    var taskName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var isEditDialogOpen by rememberSaveable { mutableStateOf(false) }

    var editNameTask by remember { mutableStateOf(taskName) }
    var editDescriptionTask by remember { mutableStateOf(description) }



    if (isAddDialogOpen) {
        AlertDialog(onDismissRequest = { isAddDialogOpen = false }, confirmButton = {
            Button(onClick = {
                if (taskName == "" || description == "") {
                    Toast.makeText(context, "Filed Is Empty", Toast.LENGTH_SHORT).show()

                } else {
                    viewModel.addNewTask(
                        DatabaseModel(
                            Calendar.getInstance().timeInMillis.toInt(), taskName, description
                        )
                    )
                    taskName = ""
                    description = ""
                    Toast.makeText(context, "New Task Added", Toast.LENGTH_SHORT).show()
                    isAddDialogOpen = false
                }
            }) {
                Text("Add New Task")
            }
        },
//
            text = {
                Column {
                    OutlinedTextField(
                        value = taskName,
                        onValueChange = { taskName = it },
                        label = { Text("Task Name") },
                        modifier = Modifier.padding(10.dp)

                    )
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description") },
                        modifier = Modifier.padding(10.dp)

                    )
                }
            })
    }
    if (isEditDialogOpen) {
        AlertDialog(onDismissRequest = { isEditDialogOpen = false }, confirmButton = {
            Button(onClick = {
                viewModel.editTask(
                    editNameTask, editDescriptionTask
                )
                isEditDialogOpen = false

            }) {
                Text("Edit  Task")
            }
        },

            text = {
                Column {
                    OutlinedTextField(
                        value = taskName,
                        onValueChange = { taskName = it },
                        label = { Text("Task Name") },
                        modifier = Modifier.padding(10.dp)

                    )
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description") },
                        modifier = Modifier.padding(10.dp)

                    )
                }
            })
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            isAddDialogOpen = true
        }) {
            Text("Add New Task Dialog")
        }

        LazyColumn {
            items(taskList) { task ->
                CardItemAdd(task, editNameTask, editDescriptionTask, onDeleteTodo = {
                    viewModel.removeTask(task.id)
                }, onEditTodo = {
                    isEditDialogOpen = true
                    viewModel.editTask(task.taskName, task.description)
                })

            }
        }

    }


}

@Composable
fun CardItemAdd(
    task: DatabaseModel,
    editNameTask: String,
    editDescriptionTask: String,
    onDeleteTodo: () -> Unit,
    onEditTodo: () -> Unit,
) {
    Card {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(editNameTask)
            Spacer(modifier = Modifier.size(10.dp))
            Text(editDescriptionTask)
            Spacer(modifier = Modifier.size(10.dp))
            IconButton(onClick = onEditTodo) {
                Icon(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "",
                    tint = Color.Black,
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            IconButton(onClick = onDeleteTodo) {
                Icon(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "",
                    tint = Color.Black,
                )
            }
        }
    }
}

