package com.example.day2.app.data.repository

import androidx.lifecycle.LiveData
import com.example.day2.app.data.local.DatabaseDao
import com.example.day2.app.data.local.DatabaseModel

class DatabaseRepository(val databaseDao: DatabaseDao) {
    val allTasks: LiveData<List<DatabaseModel>> = databaseDao.getAllTask()
    suspend fun addNewTask(databaseModel: DatabaseModel) =
        databaseDao.addNewTask(databaseModel)

    suspend fun removeTask(taskID: Int) = databaseDao.removeTask(taskID)
    suspend fun editTask(taskName: String, description: String) =
        databaseDao.editTask(taskName, description)
}