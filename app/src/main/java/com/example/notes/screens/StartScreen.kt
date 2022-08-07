package com.example.notes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.navigate.NavRoute

@Composable
fun StartScreen (navController: NavHostController) {
    Scaffold() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "What will you choose?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            Button(
                onClick = {
                navController.navigate(NavRoute.MainScreen.route)
                },
                modifier = Modifier.width(200.dp)
                ) {
                Text(text = "Room database")
            }
            Button(
                onClick = {
                    navController.navigate(NavRoute.MainScreen.route)
                },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Firebase database")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen(navController = rememberNavController())
}