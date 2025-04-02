package com.example.patienttracker.app.presention.patient_details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun PatientDetailsScreen(
    viewModel: PatientDetailsViewModel
) {
    val state = viewModel.state
    val focusRequest = remember { FocusRequester() }

    LaunchedEffect(key1 = Unit) {
        delay(500)
        focusRequest.requestFocus()
    }

    Scaffold(
        topBar = {
            TopBar(onBackClicked = {})
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(it),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequest),
                value = state.name,
                onValueChange = { newValue ->
                    viewModel.onEvent(
                        PatientDetailsEvents.EnteredName(
                            newValue
                        )
                    )
                },
                label = { Text(text = "Name ") },
                textStyle = MaterialTheme.typography.bodySmall,
                singleLine = true,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = state.age,
                    onValueChange = { newValue ->
                        viewModel.onEvent(
                            PatientDetailsEvents.EnteredAge(
                                newValue
                            )
                        )
                    },
                    label = { Text(text = "Age ") },
                    textStyle = MaterialTheme.typography.bodySmall,
                    singleLine = true,
                )
                RadioGroup(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "Male",
                    selected = state.gender == 1,
                    onClick = { viewModel.onEvent(PatientDetailsEvents.SelectedMale) }
                )
                RadioGroup(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "Female",
                    selected = state.gender == 2,
                    onClick = { viewModel.onEvent(PatientDetailsEvents.SelectedFemale) }
                )
            }
            Column {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.doctorAssigned,
                    onValueChange = { newValue ->
                        viewModel.onEvent(
                            PatientDetailsEvents.EnteredAssignedDoctor(
                                newValue
                            )
                        )
                    },
                    label = { Text(text = "Assign ... ") },
                    singleLine = true,

                    )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    value = state.prescription,
                    onValueChange = { newValue ->
                        viewModel.onEvent(
                            PatientDetailsEvents.EnteredPrescription(
                                newValue
                            )
                        )
                    },
                    label = { Text(text = "Prescription ... ") },
                    singleLine = true,
                )
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Save")
                }
            }

        }
    }

}

@Composable
fun RadioGroup(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    selected: Boolean
) {
    Row(
        modifier = Modifier.clickable { onClick },
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary
            ),
        )
        Text(text = text)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onBackClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Patient 's Details Screen")
        }, navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        }
    )

}