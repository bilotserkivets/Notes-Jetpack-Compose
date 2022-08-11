package com.example.notes.screens

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@Composable
fun NoteScreen (navController: NavHostController, viewModel: MainViewModel) {
    Scaffold() {
        Card(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(
                    text = "Title1",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Subtitle1",
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    NoteScreen(navController = rememberNavController(), viewModel = mViewModel)
}