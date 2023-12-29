package com.example.myapplication.data.repo

import com.example.myapplication.data.dao.ToDoDao
import com.example.myapplication.data.model.ToDo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val toDoDao: ToDoDao) : ToDoRepository {
    override suspend fun insert(toDo: ToDo) {
        toDoDao.insert(toDo)
    }

    override fun getTodo(): Flow<List<ToDo>> = toDoDao.getTodo()

    override suspend fun update(toDo: ToDo) {
        toDoDao.update(toDo)
    }

    override suspend fun delete(toDo: ToDo) {
        toDoDao.delete(toDo)
    }

    override suspend fun deleteAll() {
        toDoDao.deleteAll()
    }
}