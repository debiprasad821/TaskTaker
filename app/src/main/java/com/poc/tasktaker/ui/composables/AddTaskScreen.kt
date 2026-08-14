package com.poc.tasktaker.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poc.tasktaker.R
import com.poc.tasktaker.ui.components.CustomInputField
import com.poc.tasktaker.ui.theme.Gray

@Composable
fun AddTaskScreenRoute() {
    AddTaskScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(device = Devices.PIXEL_3)
fun AddTaskScreen() {
    var taskName by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var dueDate by remember {
        mutableStateOf("")
    }

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    val datePickerState = rememberDatePickerState()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .size(30.dp),
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                },
                title = {
                    Text(
                        text = "Create New Task", style = MaterialTheme.typography.titleMedium.copy(
                            fontFamily = FontFamily(
                                Font(R.font.poppins_semibold)
                            )
                        )
                    )
                })
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(15.dp)
        ) {
            Text(
                text = "Task Name",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = FontFamily(
                        Font(R.font.poppins_regular)
                    ),
                    color = Gray
                )
            )

            CustomInputField(
                value = taskName,
                onValueChange = {
                    taskName = it
                }
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Description",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = FontFamily(
                        Font(R.font.poppins_regular)
                    ),
                    color = Gray
                )
            )

            CustomInputField(
                value = description,
                onValueChange = {
                    description = it
                },
                isSingleLine = false,
                maxLines = 10
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Due Date",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = FontFamily(
                        Font(R.font.poppins_regular)
                    ),
                    color = Gray
                )
            )

            CustomInputField(
                value = dueDate,
                onValueChange = {},
                endIcon = Icons.Default.DateRange,
                onEndIconClick = {
                    showDatePicker = true
                },
                isFocusable = false
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Priority",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
            ) {

                FilterChip(
                    modifier = Modifier
                        .width(80.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.Green
                    ),
                    selected = false,
                    onClick = {},
                    label = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "High")
                        }
                    }
                )

                FilterChip(
                    modifier = Modifier
                        .width(90.dp),
                    selected = true,
                    onClick = {},
                    label = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Medium")
                        }
                    }
                )

                FilterChip(
                    modifier = Modifier
                        .width(90.dp),
                    selected = true,
                    onClick = {},
                    label = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Low")
                        }
                    }
                )
            }
        }
    }
}