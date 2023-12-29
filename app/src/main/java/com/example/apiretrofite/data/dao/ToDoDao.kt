package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.model.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(toDo: ToDo)

    @Query("SELECT * FROM todo")
    fun getTodo(): Flow<List<ToDo>>

    @Update()
    suspend fun update(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)

    @Query("DELETE FROM todo")
    suspend fun deleteAll()
}