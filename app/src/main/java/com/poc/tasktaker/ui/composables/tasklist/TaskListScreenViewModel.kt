package com.poc.tasktaker.ui.composables.tasklist

import androidx.lifecycle.ViewModel
import com.poc.tasktaker.ui.composables.tasklist.model.TaskListScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class TaskListScreenViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(TaskListScreenUiState())
    val state = _state.asStateFlow()

    fun handleEvent(event: TaskListScreenEvent) {
        when(event) {
            is TaskListScreenEvent.TaskNameChanged -> {
                _state.value = _state.value.copy(
                    taskName = event.taskName
                )
            }
            is TaskListScreenEvent.DescriptionChanged -> {
                _state.value = _state.value.copy(
                    description = event.description
                )
            }
            is TaskListScreenEvent.DueDateSelected -> {
                _state.value = _state.value.copy(
                    dueDate = convertMillisToDate(event.dueDate)
                )
            }
            is TaskListScreenEvent.IsReminderEnabled -> {
                _state.value = _state.value.copy(
                    isReminderEnabled = event.isReminderEnabled
                )
            }
            is TaskListScreenEvent.PrioritySelected -> {
                _state.value = _state.value.copy(
                    priority = event.priority
                )
            }
            is TaskListScreenEvent.DueTimeSelected -> {
                _state.value = _state.value.copy(
                    dueTime = event.dueTime
                )
            }
        }
    }

    private fun convertMillisToDate(dueDate: String): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return formatter.format(dueDate.toLong())
    }
}