package com.kodeflap.desknot.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {

    val getAllData: LiveData<List<TaskInfo>> = taskDao.getAllData()

    suspend fun insertData(toDoData: TaskInfo) = taskDao.insertData(toDoData)

    suspend fun updateData(toDoData: TaskInfo) = taskDao.updateData(toDoData)

    suspend fun deleteItem(toDoData: TaskInfo) = taskDao.deleteItem(toDoData)

    suspend fun deleteAll() = taskDao.deleteAll()

    fun searchDatabase(searchQuery: String) = taskDao.searchDatabase(searchQuery)

    fun sortByHighPriority() = taskDao.sortByHighPriority()

    fun sortByLowPriority() = taskDao.sortByLowPriority()
}