package com.poc.tasktaker.ui.composables.tasklist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.poc.tasktaker.R
import com.poc.tasktaker.ui.components.CustomInputField
import com.poc.tasktaker.ui.composables.tasklist.model.TaskListScreenUiState
import com.poc.tasktaker.ui.theme.Background
import com.poc.tasktaker.ui.theme.Gray


@Composable
fun TasksScreenRoute(viewModel: TaskListScreenViewModel = viewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    TasksScreen(
        state = state,
        onEvent = { event ->
            viewModel.handleEvent(event)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    state: TaskListScreenUiState,
    onEvent: (TaskListScreenEvent) -> Unit
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val datePickerState = rememberDatePickerState(System.currentTimeMillis())
    val timePickerState = rememberTimePickerState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .shadow(
                        elevation = 10.dp,
                        shape = CircleShape
                    ),
                onClick = {
                    showBottomSheet = true
                },
                shape = CircleShape,
                containerColor = Color.Black
            ) {
                Text(
                    text = "+",
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color.White
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Background)
                .padding(paddingValues)
                .padding(20.dp)
        ) {
            Text(
                text = "Manage Your\nDaily Task",
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color.Black
            )
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    showBottomSheet = false
                }
            ) {
                AddNewTaskContent(
                    state = state,
                    onEvent = { event ->
                        onEvent(event)
                    },
                    onClickSelectDate = {
                        showDatePicker = true
                    },
                    onClickSelectTime = {
                        showTimePicker = true
                    }
                )
            }
        }

        if (showTimePicker) {
            Dialog(
                onDismissRequest = {},
                properties = DialogProperties(
                    usePlatformDefaultWidth = true
                )
            ) {
                Surface(
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(color = Color.Transparent),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TimePicker(
                            state = timePickerState
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 15.dp,
                                alignment = Alignment.End
                            )
                        ) {
                            Text(
                                text = "Cancel",
                                modifier = Modifier
                                    .clickable(onClick = { showTimePicker = false })
                            )
                            Text(
                                text = "Ok",
                                modifier = Modifier
                                    .clickable(
                                        onClick = {
                                            showTimePicker = false
                                            val hour = timePickerState.hour
                                            val minute = timePickerState.minute
                                            onEvent(
                                                TaskListScreenEvent.DueTimeSelected(
                                                    "$hour : $minute"
                                                )
                                            )
                                        }
                                    )
                            )
                        }
                    }
                }
            }
        }


        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = {},
                confirmButton = {
                    Text(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    showDatePicker = false
                                    val selectedDate = datePickerState.selectedDateMillis
                                    onEvent(
                                        TaskListScreenEvent.DueDateSelected(
                                            selectedDate?.toString() ?: ""
                                        )
                                    )
                                }
                            ),
                        text = "Select",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp
                    )
                },
                dismissButton = {
                    Text(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    showDatePicker = false
                                }
                            ),
                        text = "Cancel",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp
                    )
                }
            ) {
                DatePicker(
                    state = datePickerState
                )
            }
        }
    }
}

@Composable
fun AddNewTaskContent(
    state: TaskListScreenUiState,
    onEvent: (TaskListScreenEvent) -> Unit,
    onClickSelectDate: () -> Unit,
    onClickSelectTime: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Create New Task",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color.Black
            )

            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close"
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Task Name",
            color = Gray,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular))
        )

        Spacer(modifier = Modifier.height(2.dp))

        CustomInputField(
            value = state.taskName,
            onValueChange = {
                onEvent(TaskListScreenEvent.TaskNameChanged(it))
            },
            placeHolder = "Enter Task Name"
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Description",
            color = Gray,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular))
        )

        Spacer(modifier = Modifier.height(2.dp))

        CustomInputField(
            value = state.description,
            onValueChange = {
                onEvent(TaskListScreenEvent.DescriptionChanged(it))
            },
            placeHolder = "Enter Task Details",
            isSingleLine = false,
            maxLines = 10
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Due Date",
                    color = Gray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )

                Spacer(modifier = Modifier.height(2.dp))

                CustomInputField(
                    value = state.dueDate,
                    onValueChange = {},
                    placeHolder = "Select Due Date",
                    endIcon = Icons.Default.DateRange,
                    isFocusable = false,
                    onEndIconClick = onClickSelectDate
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Due Time",
                    color = Gray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )

                Spacer(modifier = Modifier.height(2.dp))

                CustomInputField(
                    value = state.dueTime,
                    onValueChange = {},
                    placeHolder = "Select Due Time",
                    endIcon = Icons.Default.DateRange,
                    isFocusable = false,
                    onEndIconClick = onClickSelectTime
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Get Reminder",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            )

            Switch(
                modifier = Modifier
                    .scale(.7f),
                checked = state.isReminderEnabled,
                onCheckedChange = {
                    onEvent(TaskListScreenEvent.IsReminderEnabled(it))
                },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        PrioritySelector(
            selectedPriority = state.priority,
            onPrioritySelected = { priority ->
                onEvent(TaskListScreenEvent.PrioritySelected(priority))
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp
            ),
            onClick = {}
        ) {
            Text(
                text = "Add Task",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            )
        }
    }
}
