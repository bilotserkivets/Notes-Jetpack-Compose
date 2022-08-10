package com.example.notes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.notes.database.DatabaseRepository
import com.example.notes.database.room.dao.AppRoomDatabase
import com.example.notes.database.room.repository.RoomRepository
import com.example.notes.model.Note
import com.example.notes.utils.REPOSITORY
import com.example.notes.utils.TYPE_FIREBASE
import com.example.notes.utils.TYPE_ROOM

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    val dataTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }
    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("checkDatabase", "initDatabase $type")
        dbType.value = type

        val dao = AppRoomDatabase.getInstance(context).getRoomDao()

        when(type) {
            TYPE_ROOM -> {
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }


    }
}