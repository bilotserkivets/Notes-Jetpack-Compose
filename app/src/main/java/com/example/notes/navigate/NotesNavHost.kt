package com.example.notes.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.screens.AddScreen
import com.example.notes.screens.MainScreen
import com.example.notes.screens.NoteScreen
import com.example.notes.screens.StartScreen

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route) {
            StartScreen(navController)
        }
        composable(NavRoute.MainScreen.route) {
            MainScreen(navController)
        }
        composable(NavRoute.AddScreen.route) {
            AddScreen(navController)
        }
        composable(NavRoute.NoteScreen.route) {
            NoteScreen(navController)
        }
    }
}