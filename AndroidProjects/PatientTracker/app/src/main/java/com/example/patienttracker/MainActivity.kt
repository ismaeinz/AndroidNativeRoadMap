package com.example.patienttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.patienttracker.app.navigation.NavGraphSetup
import com.example.patienttracker.app.presention.patient_details.PatientDetailsViewModel
import com.example.patienttracker.app.presention.theme.PatientTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PatientTrackerTheme {
                val viewModel = viewModel<PatientDetailsViewModel>()
                val navController = rememberNavController()
                NavGraphSetup(navController = navController)
            }
        }
    }
}
