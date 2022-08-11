package com.example.notes.screens

import android.app.Application
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.MainViewModel
import com.example.notes.MainViewModelFactory
import com.example.notes.model.Note
import com.example.notes.navigate.NavRoute

@Composable
fun AddScreen (navController: NavHostController, viewModel: MainViewModel) {
    var title by remember {
        mutableStateOf("")
    }
    var subtitle by remember {
        mutableStateOf("")
    }
    var isButtonEnabled by remember {
        mutableStateOf(false)
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
                    isError = title.isEmpty(),
                    label = {
                        Text(text = "Write title")
                    },
                    onValueChange = {
                        title = it
                        isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                    }
                )
                OutlinedTextField(
                    value = subtitle,
                    isError = subtitle.isEmpty(),
                    label = {
                        Text(text = "Write subtitle")
                    },
                    onValueChange = {
                        subtitle = it
                        isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                    }
                )
                Button(
                    modifier = Modifier.padding(top = 16.dp),
                    enabled = isButtonEnabled,
                    onClick = {
                        viewModel.addNote(note = Note(title = title, subtitle = subtitle)) {
                            navController.navigate(NavRoute.MainScreen.route)
                        }
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
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    AddScreen(navController = rememberNavController(), viewModel = mViewModel)
}