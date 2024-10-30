package com.kodeflap.desknot.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY id ASC")
    fun getAllData(): LiveData<List<TaskInfo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(taskInfo: TaskInfo)

    @Update
    suspend fun updateData(taskInfo: TaskInfo)

    @Delete
    suspend fun deleteItem(taskInfo: TaskInfo)

    @Query("DELETE FROM task")
    suspend fun deleteAll()

    @Query("SELECT * FROM task WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<TaskInfo>>

    @Query(
        "SELECT * FROM task ORDER BY CASE " +
        "WHEN priority LIKE 'H%' THEN 1 " +
        "WHEN priority LIKE 'M%' THEN 2 " +
        "WHEN priority LIKE 'L%' THEN 3 END"
    )
    fun sortByHighPriority(): LiveData<List<TaskInfo>>

    @Query(
        "SELECT * FROM task ORDER BY CASE " +
        "WHEN priority LIKE 'L%' THEN 1 " +
        "WHEN priority LIKE 'M%' THEN 2 " +
        "WHEN priority LIKE 'H%' THEN 3 END"
    )
    fun sortByLowPriority(): LiveData<List<TaskInfo>>
}