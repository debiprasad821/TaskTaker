package com.poc.task.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.getDefault())
    .withZone(ZoneId.systemDefault())

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toFormattedDate(): String {
    val instant = Instant.ofEpochMilli(this)
    return formatter.format(instant)
}