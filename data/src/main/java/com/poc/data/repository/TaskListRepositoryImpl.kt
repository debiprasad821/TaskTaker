package com.poc.data.repository

import com.poc.data.local.Task
import com.poc.data.local.TaskDao
import com.poc.work.TaskReminderScheduler
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskListRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao,
    private val taskReminderScheduler: TaskReminderScheduler
) : TaskListRepository {
    override suspend fun createTask(task: Task, isReminderEnabled: Boolean) {
        if (isReminderEnabled) {
            taskReminderScheduler.scheduleReminder(
                task.title,
                task.description,
                task.dueDateTime
            )
        }
        taskDao.insertTask(task)
    }

    override fun getTasks(): Flow<List<Task>> {
        return taskDao.getTasks()
    }
}