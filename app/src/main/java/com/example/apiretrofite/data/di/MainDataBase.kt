package com.example.myapplication.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.db.MainDatabase
import com.example.myapplication.util.Constant.dbName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainDataBase {
    @Singleton
    @Provides
    fun provideDb(@ApplicationContext applicationContext: Context): MainDatabase {
        return Room.databaseBuilder(
            applicationContext,
            MainDatabase::class.java, dbName
        ).build()
    }

    @Singleton
    @Provides
    fun provideToDoDao(mainDatabase: MainDatabase) = mainDatabase.todoDao()
}