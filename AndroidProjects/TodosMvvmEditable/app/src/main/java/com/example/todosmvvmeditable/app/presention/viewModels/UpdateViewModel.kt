package com.example.todosmvvmeditable.app.presention.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todosmvvmeditable.app.domain.entity.Note
import com.example.todosmvvmeditable.app.domain.usecase.NoteUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class UpdateViewModel @Inject constructor(
    private val useCase: NoteUseCase, private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var title by mutableStateOf("")
    var content by mutableStateOf("")

    val id = savedStateHandle.get<Int>(key = "id")

    init {

        viewModelScope.launch {
            val note = id?.let { useCase.getByIdNote(it) }

            if (note != null) {
                title = note.title
                content = note.content
            }
        }
    }

    fun updateNote() = viewModelScope.launch {
        useCase.updateNote(
            Note(
                id!!,
                title,
                content = content,
            )
        )
    }
}