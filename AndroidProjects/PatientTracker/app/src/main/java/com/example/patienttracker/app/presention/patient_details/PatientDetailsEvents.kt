package com.example.patienttracker.app.presention.patient_details

sealed class PatientDetailsEvents {
    data class EnteredName(val name: String) : PatientDetailsEvents()
    data class EnteredAge(val age: String) : PatientDetailsEvents()
    data class EnteredAssignedDoctor(val name: String) : PatientDetailsEvents()
    data class EnteredPrescription(val name: String) : PatientDetailsEvents()

    object SelectedMale : PatientDetailsEvents()
    object SelectedFemale : PatientDetailsEvents()
    object SaveButton : PatientDetailsEvents()


}