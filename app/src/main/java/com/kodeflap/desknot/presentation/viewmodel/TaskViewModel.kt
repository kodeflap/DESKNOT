package com.kodeflap.desknot.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kodeflap.desknot.data.TaskDatabase
import com.kodeflap.desknot.data.TaskInfo
import com.kodeflap.desknot.data.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val taskDatabase = TaskDatabase.getDatabase(application).taskDao()
    private val repository: TaskRepository = TaskRepository(taskDatabase)
    val getAllData: LiveData<List<TaskInfo>> = repository.getAllData
    val sortedDataHigh: LiveData<List<TaskInfo>> = repository.sortByHighPriority()
    val sortedDataLow: LiveData<List<TaskInfo>> = repository.sortByLowPriority()

    fun insertData(toDoData: TaskInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(toDoData)
        }
    }

    fun updateData(toDoData: TaskInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(toDoData)
        }
    }

    fun deleteItem(toDoData: TaskInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(toDoData)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    fun searchDatabase(searchQuery: String) = repository.searchDatabase(searchQuery)
}