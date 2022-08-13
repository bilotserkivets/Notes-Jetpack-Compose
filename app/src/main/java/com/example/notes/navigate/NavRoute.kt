package com.example.notes.navigate

import com.example.notes.utils.Constants

sealed class NavRoute(val route: String) {
    object StartScreen : NavRoute(Constants.Screens.START_SCREEN)
    object MainScreen : NavRoute(Constants.Screens.MAIN_SCREEN)
    object AddScreen : NavRoute(Constants.Screens.ADD_SCREEN)
    object NoteScreen : NavRoute(Constants.Screens.NOTE_SCREEN)
}
