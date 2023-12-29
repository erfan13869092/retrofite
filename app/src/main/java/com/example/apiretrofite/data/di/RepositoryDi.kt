package com.example.myapplication.data.di

import com.example.myapplication.data.repo.ToDoRepository
import com.example.myapplication.data.repo.ToDoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryDi {
    @Binds
    abstract fun provideRepositoryToDo(toDoRepositoryImpl: ToDoRepositoryImpl): ToDoRepository
}