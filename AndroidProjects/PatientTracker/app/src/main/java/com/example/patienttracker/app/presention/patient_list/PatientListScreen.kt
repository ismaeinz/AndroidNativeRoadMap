@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.patienttracker.app.presention.patient_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patienttracker.app.domain.model.Patient

@Preview
@Composable
fun PatientListScreen() {
    val patientList = listOf(
        Patient(
            name = "Name",
            age = 20,
            gender = 0,
            doctorAssigned = "doctorAssigned",
            patientId = 1
        ),
        Patient(
            name = "Name",
            age = 20,
            gender = 0,
            doctorAssigned = "doctorAssigned",
            patientId = 1
        ),
    )
    Scaffold(
        topBar = {
            ListAppBar()
        },
        floatingActionButton = { ListFeb(onFebClicked = {}) }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            contentPadding = PaddingValues(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(patientList) { patient ->
                PatientItem(patient = patient, onItemClicked = {}, onDeleteConfirm = {})

            }
        }
        if (patientList.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Add Patients Details \n by passing add Button ", style =
                        MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ListAppBar() {
    TopAppBar(title = {
        Text(
            text = "Patient Tracker",
            style = MaterialTheme.typography.headlineMedium
        )
    }
    )
}

@Composable
fun ListFeb(
    onFebClicked: () -> Unit
) {

    FloatingActionButton(onClick = onFebClicked) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = ""
        )
    }

}