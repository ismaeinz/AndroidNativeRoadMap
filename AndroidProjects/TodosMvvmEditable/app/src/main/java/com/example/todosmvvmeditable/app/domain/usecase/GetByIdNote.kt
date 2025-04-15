package com.example.todosmvvmeditable.app.domain.usecase

import com.example.todosmvvmeditable.app.data.repositoryImpl.RepositoryImpl
import javax.inject.Inject

class GetByIdNote @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend operator fun invoke(id: Int) = repositoryImpl.getByIdNote(id)
}