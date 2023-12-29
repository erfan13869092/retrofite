package com.example.myapplication.data.repo

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.model.ToDo
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun insert(toDo: ToDo)

    fun getTodo(): Flow<List<ToDo>>

    suspend fun update(toDo: ToDo)

    suspend fun delete(toDo: ToDo)

    suspend fun deleteAll()
}