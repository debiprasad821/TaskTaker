package com.poc.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poc.data.local.Task
import com.poc.data.repository.TaskListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class TaskListScreenViewModel @Inject constructor(
    private val taskListRepository: TaskListRepository
) : ViewModel() {
    private val _state = MutableStateFlow(TaskListScreenUiState())
    val state = _state.asStateFlow()

    fun handleEvent(event: TaskListScreenEvent) {
        when (event) {
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

            is TaskListScreenEvent.AddTask -> {
                createTask()
            }

            is TaskListScreenEvent.LoadTask -> {
                loadTasks()
            }
        }
    }

    private fun loadTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            taskListRepository.getTasks().collect { tasks ->
                _state.value = _state.value.copy(
                    tasks = tasks
                )
            }
        }
    }

    private fun createTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val title = _state.value.taskName
            val description = _state.value.description
            val priority = _state.value.priority
            val dueDate = _state.value.dueDate
            val dueTime = _state.value.dueTime
            val isReminderEnabled = _state.value.isReminderEnabled
            val timeStamp = getTimeStamp(dueDate, dueTime)

            val task = Task(
                title = title,
                description = description,
                dueDateTime = timeStamp,
                priority = priority
            )
            taskListRepository.createTask(task, isReminderEnabled = true)
        }
    }

    private fun getTimeStamp(date: String, time: String): Long? {
        val calender = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        calender.time = dateFormat.parse(date) ?: return null

        return try {
            val timeParts = time.split(":")
            calender.set(Calendar.HOUR_OF_DAY, timeParts[0].toInt())
            calender.set(Calendar.MINUTE, timeParts[1].toInt())
            calender.set(Calendar.SECOND, 0)
            calender.set(Calendar.MILLISECOND, 0)
            calender.timeInMillis
        } catch (exception: Exception) {
            null
        }
    }

    private fun convertMillisToDate(dueDate: String): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return formatter.format(dueDate.toLong())
    }
}