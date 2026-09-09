package com.poc.data.repository

import com.poc.data.local.Task
import kotlinx.coroutines.flow.Flow

interface TaskListRepository {
    suspend fun createTask(task: Task, isReminderEnabled: Boolean)
    fun getTasks(): Flow<List<Task>>
}