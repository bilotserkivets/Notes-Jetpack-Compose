package com.example.notes.utils

import com.example.notes.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository

object Constants {
    object Keys {
        const val NOTES_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "Add new note"
        const val NOTE_TITLE = "Note title"
        const val NOTE_SUBTITLE = "Note subtitle"
        const val ADD_NOTE = "Add note"
        const val WHAT_WILL_YOU_CHOOSE = "What will you choose?"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE_DATABASE = "Firebase database"
        const val ID = "id"
        const val NONE = "none"
        const val UPDATE = "Update"
        const val DELETE = "Delete"
        const val ROW_BACK = "Row back"
        const val UPDATE_NOTE = "Update note"
        const val EMPTY = "Empty"
    }
    object Screens {
         const val START_SCREEN = "start_screen"
         const val MAIN_SCREEN = "main_screen"
         const val ADD_SCREEN = "add_screen"
         const val NOTE_SCREEN = "note_screen"
    }
}