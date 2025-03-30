
package com.example.patienttracker.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColorScheme(
    primary = RoyalBlue,
    secondary = Teal200
)

private val LightColorPalette = lightColorScheme(
    primary = RoyalBlue,
    secondary = Teal200
)

@Composable
fun PatientTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colors.inverseSurface
    )

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}