package com.example.notes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.navigate.NavRoute

@Composable
fun AddScreen (navController: NavHostController) {
    var title by remember {
        mutableStateOf("")
    }
    var subtitle by remember {
        mutableStateOf("")
    }

    Scaffold() {
        Card(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(
                    text = "Add your note",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                OutlinedTextField(
                    value = title,
                    label = {
                        Text(text = "Write title")
                    },
                    onValueChange = {
                        title = it
                    }
                )
                OutlinedTextField(
                    value = subtitle,
                    label = {
                        Text(text = "Write subtitle")
                    },
                    onValueChange = {
                        subtitle = it
                    }
                )
                Button(
                    onClick = {
                    navController.navigate(NavRoute.MainScreen.route)
                    }
                ) {
                    Text(text = "Add note")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    AddScreen(navController = rememberNavController())
}