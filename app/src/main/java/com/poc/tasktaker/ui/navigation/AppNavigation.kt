package com.poc.tasktaker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poc.tasktaker.ui.composables.AddTaskScreenRoute
import com.poc.tasktaker.ui.composables.TasksScreenRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TaskList
    ) {
        composable<TaskList> {
            TasksScreenRoute(
                navigateToAddTask = {
                    navController.navigate(AddTask)
                }
            )
        }

        composable<AddTask> {
            AddTaskScreenRoute()
        }
    }
}