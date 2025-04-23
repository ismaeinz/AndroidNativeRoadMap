package com.example.todosmvvmeditable.app.presention.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todosmvvmeditable.app.domain.entity.Note
import com.example.todosmvvmeditable.app.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: NoteUseCase
) : ViewModel() {
    val notes = useCase.getNotes()
    fun deleteNote(note: Note) = viewModelScope.launch {
        useCase.deleteNote(note)
    }

}