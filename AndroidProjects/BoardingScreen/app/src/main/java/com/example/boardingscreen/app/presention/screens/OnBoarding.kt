package com.example.boardingscreen.app.presention.screens

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun OnBoarding(modifier: Modifier = Modifier) {
    Text("OnBoarding")
}

@Preview
@Composable
fun TopSection(modifier: Modifier = Modifier) {
    Box(
        modifier= Modifier.fillMaxSize().padding(12.dp)
    ){
        IconButton(onClick = {},
            modifier= Modifier.align(Alignment.CenterStart)){
            Icon(Icons.Outlined.KeyboardArrowLeft,null)

        }
        IconButton(onClick = {},
            modifier= Modifier.align(Alignment.CenterEnd)){
            Text("Skip",color= MaterialTheme.colors.onBackground)

        }

    }
}

@Preview
@Composable
fun RowScope.Indicator() {
    val isSelected=true
    val width= animateDpAsState(
        if(isSelected) 25.dp else 10.dp,
    )
}
