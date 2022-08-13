package com.example.notes.screens

import android.app.Application
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
import com.example.notes.navigate.NavRoute
import com.example.notes.utils.Constants
import com.example.notes.utils.TYPE_FIREBASE
import com.example.notes.utils.TYPE_ROOM

@Composable
fun StartScreen (navController: NavHostController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    Scaffold() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = Constants.Keys.WHAT_WILL_YOU_CHOOSE,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_ROOM) {
                        navController.navigate(NavRoute.MainScreen.route)
                    }
                },
                modifier = Modifier.width(200.dp)
                ) {
                Text(text = Constants.Keys.ROOM_DATABASE)
            }
            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_FIREBASE){
                        navController.navigate(NavRoute.MainScreen.route)
                    }
                },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = Constants.Keys.FIREBASE_DATABASE)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    StartScreen(navController = rememberNavController(), viewModel = mViewModel)
}