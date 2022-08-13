package com.example.notes.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.MainViewModel
import com.example.notes.screens.AddScreen
import com.example.notes.screens.MainScreen
import com.example.notes.screens.NoteScreen
import com.example.notes.screens.StartScreen
import com.example.notes.utils.Constants

@Composable
fun NotesNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route) {
            StartScreen(navController, viewModel = mViewModel)
        }
        composable(NavRoute.MainScreen.route) {
            MainScreen(navController, viewModel = mViewModel)
        }
        composable(NavRoute.AddScreen.route) {
            AddScreen(navController, viewModel = mViewModel)
        }
        composable(NavRoute.NoteScreen.route + "/{${Constants.Keys.ID}}") { backStack ->
            NoteScreen(navController, viewModel = mViewModel, noteId = backStack.arguments?.getString(Constants.Keys.ID))
        }
    }
}