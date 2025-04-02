package com.example.patienttracker.app.domain.model

data class Patient(
    val name: String,
    val age: Int,
    val gender: Int,
    val doctorAssigned: String,
    val patientId: Int? = null
)