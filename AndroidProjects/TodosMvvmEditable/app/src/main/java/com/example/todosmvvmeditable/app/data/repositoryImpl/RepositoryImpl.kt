package com.example.todosmvvmeditable.app.data.repositoryImpl

import com.example.todosmvvmeditable.app.domain.entity.Note
import com.example.todosmvvmeditable.app.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RepositoryImpl @Inject constructor(private val dao: Repository) : Repository {
    override suspend fun insertNote(note: Note) = dao.insertNote(note = note)
    override suspend fun updateNote(note: Note) = dao.updateNote(note = note)
    override suspend fun deleteNote(note: Note) = dao.deleteNote(note = note)
    override fun getNotes(): Flow<List<Note>> = dao.getNotes()
    override suspend fun getByIdNote(id: Int): Note = dao.getByIdNote(id)

}