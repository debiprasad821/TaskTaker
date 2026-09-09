package com.poc.work

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TaskReminderScheduler @Inject constructor(
    @ApplicationContext context: Context
) {
    val workManager = WorkManager.getInstance(context)

    fun scheduleReminder(
        taskTitle: String,
        description: String,
        dueTime: Long?
    ) {

        val inputData = workDataOf(
            "TASK_TITLE" to taskTitle,
            "TASK_DESCRIPTION" to description
        )

        val workRequest = OneTimeWorkRequestBuilder<TaskReminderWorker>()
            .setInitialDelay(
                10L,
                TimeUnit.SECONDS
            )
            .setInputData(inputData)
            .build()
        workManager.enqueue(workRequest)
    }
}