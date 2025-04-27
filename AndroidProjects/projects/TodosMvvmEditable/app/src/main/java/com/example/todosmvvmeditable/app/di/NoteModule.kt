package com.example.todosmvvmeditable.app.di

import android.content.Context
import androidx.room.Room
import com.example.todosmvvmeditable.app.data.local.NoteDatabase
import com.example.todosmvvmeditable.app.data.repositoryImpl.RepositoryImpl
import com.example.todosmvvmeditable.app.domain.usecase.DeleteNote
import com.example.todosmvvmeditable.app.domain.usecase.GetByIdNote
import com.example.todosmvvmeditable.app.domain.usecase.GetNotes
import com.example.todosmvvmeditable.app.domain.usecase.InsertNote
import com.example.todosmvvmeditable.app.domain.usecase.NoteUseCase
import com.example.todosmvvmeditable.app.domain.usecase.UpdateNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase = Room.databaseBuilder(
        context = context,
        klass = NoteDatabase::class.java,
        name = "noteDatabase"
    ).build()

    @Provides
    fun provideDao(dao: NoteDatabase) = dao.noteDao()

    @Provides
    fun provideNoteUseCase(repository: RepositoryImpl) = NoteUseCase(
        getNotes = GetNotes(repository),
        getByIdNote = GetByIdNote(repository),
        deleteNote = DeleteNote(repository),
        updateNote = UpdateNote(repository),
        insertNote = InsertNote(repository)
    )
}