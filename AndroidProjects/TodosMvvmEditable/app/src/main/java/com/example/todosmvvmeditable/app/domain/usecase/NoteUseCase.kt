package com.example.todosmvvmeditable.app.domain.usecase

data class NoteUseCase(
    val getNotes: GetNotes,
    val insertNote: InsertNote,
    val deleteNote: DeleteNote,
    val updateNote: UpdateNote,
    val getByIdNote: GetByIdNote
)