package com.example.patienttracker.app.presention.patient_list

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun DeleteDialog(
    title: String, message: String,
    onDialogDismiss: () -> Unit,
    onConfirmButtonClicked: () -> Unit
) {
    AlertDialog(
        title = {
            Text(title)
        },
        text = {
            Text(message)

        },
        onDismissRequest = {

        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmButtonClicked
            }) {
                Text("Yes")

            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDialogDismiss()
            }) {
                Text("No")

            }
        }

    )


}