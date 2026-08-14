package com.poc.tasktaker.ui.composables.tasklist.model

data class TaskListScreenUiState(
    val taskName: String = "",
    val description: String = "",
    val dueDate: String = "",
    val dueTime: String = "",
    val priority: String = "",
    val isReminderEnabled: Boolean = false
)
