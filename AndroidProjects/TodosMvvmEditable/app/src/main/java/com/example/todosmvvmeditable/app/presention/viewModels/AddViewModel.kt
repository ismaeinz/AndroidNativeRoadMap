package com.example.todosmvvmeditable.app.presention.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todosmvvmeditable.app.domain.entity.Note
import com.example.todosmvvmeditable.app.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(val useCase: NoteUseCase) : ViewModel() {

    var title by mutableStateOf("")
    var content by mutableStateOf("")
    fun addNote() = viewModelScope.launch {
        useCase.insertNote(
            Note(
                title = title,
                content = content
            )
        )
    }
}