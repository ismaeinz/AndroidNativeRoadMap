package com.example.day2.app.presention.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.day2.app.data.local.DatabaseModel
import com.example.day2.app.data.local.MyDataBase
import com.example.day2.app.data.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseViewmodel(application: Application) : AndroidViewModel(application) {
    val databaseRepository: DatabaseRepository
    val taskList: LiveData<List<DatabaseModel>>

    init {
        val databaseDao = MyDataBase.getDatabase(application).databaseDao()
        databaseRepository = DatabaseRepository(databaseDao)
        taskList = databaseRepository.allTasks
    }

    fun addNewTask(databaseModel: DatabaseModel) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.addNewTask(databaseModel)
    }

    fun editTask(taskName: String, description: String) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.editTask(taskName, description)
    }

    fun removeTask(taskID: Int) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.removeTask(taskID)
    }

    fun getATask(taskID: Int): DatabaseModel? = taskList.value?.find { it.id == taskID }

}