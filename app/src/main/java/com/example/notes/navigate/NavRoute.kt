package com.example.notes.navigate

sealed class NavRoute(val route: String) {
    object StartScreen : NavRoute("start_screen")
    object MainScreen : NavRoute("main_screen")
    object AddScreen : NavRoute("Add_screen")
    object NoteScreen : NavRoute("Note_screen")
}
