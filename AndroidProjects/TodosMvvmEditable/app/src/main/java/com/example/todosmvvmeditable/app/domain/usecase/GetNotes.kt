package com.example.todosmvvmeditable.app.domain.usecase

import com.example.todosmvvmeditable.app.data.repositoryImpl.RepositoryImpl
import javax.inject.Inject

class GetNotes @Inject constructor(private val repository: RepositoryImpl) {
    operator fun invoke() = repository.getNotes()
}