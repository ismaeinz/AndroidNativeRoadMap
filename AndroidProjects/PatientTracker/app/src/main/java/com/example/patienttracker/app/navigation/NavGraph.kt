package com.example.patienttracker.app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.patienttracker.app.presention.patient_details.PatientDetailsScreen
import com.example.patienttracker.app.presention.patient_details.PatientDetailsViewModel
import com.example.patienttracker.app.presention.patient_list.PatientListScreen
import com.example.patienttracker.app.util.Constants.PATIENT_DETAILS_ARGUMENT_KEY


sealed class Screen(val route: String) {
    object PatientList : Screen("patient_list_screen")
    object PatientDetails : Screen(
        "patient_details_screen?$PATIENT_DETAILS_ARGUMENT_KEY=" +
                "{$PATIENT_DETAILS_ARGUMENT_KEY}"
    ) {
        fun passPatientId(patientId: Int? = null): String {
            return "patient_details_screen?$PATIENT_DETAILS_ARGUMENT_KEY=$patientId"
        }
    }
}

@Composable
fun NavGraphSetup(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PatientList.route
    ) {
        composable(
            route = Screen.PatientList.route
        ) {
            PatientListScreen(
                onFabClick = {
                    navController.navigate(Screen.PatientDetails.route)
                },
                onItemClick = { patientId ->
                    navController.navigate(Screen.PatientDetails.passPatientId(patientId))
                }
            )
        }
        composable(
            route = Screen.PatientDetails.route,
            arguments = listOf(navArgument(name = PATIENT_DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
                defaultValue = -1
            })
        ) {
            val viewModel: PatientDetailsViewModel =
                viewModel<PatientDetailsViewModel>()
            PatientDetailsScreen(
                onBackClick = { navController.navigateUp() },
                onSuccessfulSaving = { navController.navigateUp() },
                viewModel = viewModel
            )
        }
    }
}