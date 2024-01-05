package com.example.apiretrofite.data.di

import com.example.apiretrofite.data.repo.RepositoryCoin
import com.example.apiretrofite.data.repo.RepositoryCoinImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryDi {
    @Singleton
    @Binds
    abstract fun provideCoinRepository(repositoryCoinImpl: RepositoryCoinImpl): RepositoryCoin
}