package com.example.jetnote

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnote.model.Note
import com.example.jetnote.screen.NoteScreen
import com.example.jetnote.screen.NoteViewModel
import com.example.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                // this also works
                // val noteViewModel = viewModel<NoteViewModel>()
                val noteViewModel: NoteViewModel by viewModels()
                NotesApp(noteViewModel = noteViewModel)
            }
        }
    }
}

@Composable
fun NotesApp(
    noteViewModel: NoteViewModel
) {
    val noteList = noteViewModel.noteList.collectAsState().value
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        NoteScreen(
            notes = noteList,
            onAddNote = {
                noteViewModel.addNote(it)
            },
            onRemoveNote = {
                noteViewModel.deleteNote(it)
            }
        )
    }
}