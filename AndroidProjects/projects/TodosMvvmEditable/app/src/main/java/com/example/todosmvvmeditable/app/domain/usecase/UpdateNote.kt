package com.example.todosmvvmeditable.app.domain.usecase

import com.example.todosmvvmeditable.app.data.repositoryImpl.RepositoryImpl
import com.example.todosmvvmeditable.app.domain.entity.Note
import javax.inject.Inject


class UpdateNote @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend operator fun invoke(note: Note) = repositoryImpl.updateNote(note)
}