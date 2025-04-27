package com.example.todosmvvmeditable.app.domain.usecase

import com.example.todosmvvmeditable.app.data.repositoryImpl.RepositoryImpl
import com.example.todosmvvmeditable.app.domain.entity.Note

class InsertNote constructor(private val repository: RepositoryImpl) {
    suspend operator fun invoke(note: Note) = repository.insertNote(note)
}