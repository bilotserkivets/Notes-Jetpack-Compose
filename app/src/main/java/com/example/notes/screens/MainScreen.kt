package com.example.notes.screens

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    //val notes = mViewModel.dataTest.observeAsState(listOf()).value
   
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoute.AddScreen.route)
                },
                backgroundColor = Color.Blue) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add notes",
                    tint = Color.White
                )
            }
        }
    ){
//            LazyColumn() {
//                items(notes) { note ->
//                    NoteItem(note = note)
//                }
//            }
    }
}
@Composable
fun NoteItem(note: Note) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
                )
            Text(
                text = note.subtitle
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}