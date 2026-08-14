package com.poc.tasktaker.ui.composables.tasklist

sealed interface TaskListScreenEvent {
    data class TaskNameChanged(val taskName: String) : TaskListScreenEvent
    data class DescriptionChanged(val description: String) : TaskListScreenEvent
    data class DueDateSelected(val dueDate: String) : TaskListScreenEvent
    data class DueTimeSelected(val dueTime: String) : TaskListScreenEvent
    data class PrioritySelected(val priority: String) : TaskListScreenEvent
    data class IsReminderEnabled(val isReminderEnabled: Boolean) : TaskListScreenEvent
}