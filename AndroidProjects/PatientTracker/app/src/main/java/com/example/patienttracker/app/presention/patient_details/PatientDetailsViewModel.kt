package com.example.patienttracker.app.presention.patient_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PatientDetailsViewModel : ViewModel() {
    var state by mutableStateOf(PatientDetailsUiState())
    fun onEvent(event: PatientDetailsEvents) {
        when (event) {
            is PatientDetailsEvents.EnteredAge -> {
                state = state.copy(age = event.age)
            }

            is PatientDetailsEvents.EnteredAssignedDoctor -> {
                state = state.copy(doctorAssigned = event.name)

            }

            is PatientDetailsEvents.EnteredName -> {
                state = state.copy(name = event.name)
            }

            is PatientDetailsEvents.EnteredPrescription -> {
                state = state.copy(prescription = event.name)
            }

            PatientDetailsEvents.SaveButton -> {
//                state = state.copy(gender = 2)
            }

            PatientDetailsEvents.SelectedFemale -> {
                state = state.copy(gender = 2)

            }

            PatientDetailsEvents.SelectedMale -> {
                state = state.copy(gender = 1)

            }
        }
    }


}