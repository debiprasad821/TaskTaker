package com.poc.tasktaker.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


@Composable
fun TasksScreenRoute() {
    TasksScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun TasksScreen() {
    var showDatePicker by remember { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(
                modifier = Modifier
                    .clickable(
                        onClick = {
                            showDatePicker = true
                        }
                    ),
                text = "Tasks Screen"
            )
        }
    }

    if (showDatePicker) {
        val datePickerState = rememberDatePickerState()
        DatePickerDialog(
            onDismissRequest = { /* Handle dismiss */ },
            confirmButton = {
                TextButton(onClick = { showDatePicker = false }) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { /* Handle dismiss */ }) { Text("Cancel") }
            },
            // Step 1: Tell the platform to ignore default width constraints
            properties = DialogProperties(usePlatformDefaultWidth = false),
            // Step 2: Apply custom padding to the dialog container
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            DatePicker(state = datePickerState)
        }

    }
}
