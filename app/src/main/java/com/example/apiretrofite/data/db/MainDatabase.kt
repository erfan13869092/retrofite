package com.example.myapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.dao.ToDoDao
import com.example.myapplication.data.model.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}