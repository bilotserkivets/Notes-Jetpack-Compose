package com.example.notes.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.notes.utils.Constants
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NoteScreen (navController: NavHostController, viewModel: MainViewModel, noteId: String?) {
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value
    val note = notes.firstOrNull{ it.id == noteId?.toInt()} ?: Note(title = Constants.Keys.NONE, subtitle = Constants.Keys.NONE)
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var title by remember {
        mutableStateOf(Constants.Keys.EMPTY)
    }
    var subtitle by remember {
        mutableStateOf(Constants.Keys.EMPTY)
    }


    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            Surface() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                ) {
                    Text(
                        text = Constants.Keys.UPDATE_NOTE,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    OutlinedTextField(
                        value = title,
                        onValueChange = {
                            title = it
                        },
                        label = {
                            Text(Constants.Keys.NOTE_TITLE)
                        },
                        isError = title.isEmpty()
                    )
                    OutlinedTextField(
                        value = subtitle,
                        onValueChange = {
                            subtitle = it
                        },
                        label = {
                            Text(Constants.Keys.NOTE_SUBTITLE)
                        },
                        isError = subtitle.isEmpty()
                    )
                    Button(
                        onClick = {
                        viewModel.updateNote(note = Note(id = note.id, title = title, subtitle = subtitle)) {
                            navController.navigate(NavRoute.MainScreen.route)
                        }
                        }) {
                        Text(text = Constants.Keys.UPDATE)
                    }
                }
            }

        }
    ) {
        Scaffold() {
            Card(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = note.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = note.subtitle,
                        fontSize = 14.sp,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    title = note.title
                                    subtitle = note.subtitle
                                    bottomSheetState.show()
                                }
                            },
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = Constants.Keys.UPDATE)
                        }
                        Button(
                            onClick = {
                                viewModel.deleteNote(note = note) {
                                    navController.navigate(NavRoute.MainScreen.route)
                                }
                            },
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = Constants.Keys.DELETE)
                        }
                    }
                    Button(
                        onClick = {
                            navController.navigate(NavRoute.MainScreen.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(text = Constants.Keys.ROW_BACK)
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun NoteScreenPreview() {
//    val context = LocalContext.current
//    val mViewModel: MainViewModel =
//        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
//    NoteScreen(
//        navController = rememberNavController(),
//        viewModel = mViewModel,
//        noteId = "1"
//    )
//}