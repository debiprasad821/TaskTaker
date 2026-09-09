package com.poc.data.di

import com.poc.data.repository.TaskListRepository
import com.poc.data.repository.TaskListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTaskRepository(
        taskListRepositoryImpl: TaskListRepositoryImpl
    ): TaskListRepository
}