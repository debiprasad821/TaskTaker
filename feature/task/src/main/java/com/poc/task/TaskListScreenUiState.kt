package com.poc.task

import com.poc.data.local.Task

data class TaskListScreenUiState(
    val taskName: String = "",
    val description: String = "",
    val dueDate: String = "",
    val dueTime: String = "",
    val priority: String = "",
    val isReminderEnabled: Boolean = false,
    val tasks: List<Task> = emptyList()
)
