package com.example.mp.data.datasources

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mp.data.models.TaskDto


@Dao
interface TasksDao {

    @Query("SELECT * FROM TaskDto")
    fun getAll(): List<TaskDto>

    @Query("SELECT * FROM TaskDto")
    fun watchAll(): LiveData<List<TaskDto>>

    @Insert
    fun insert(todos: TaskDto)

    @Update
    fun update(note: TaskDto)

}