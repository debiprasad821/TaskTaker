package com.poc.tasktaker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poc.task.TasksScreenRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TaskList
    ) {
        composable<TaskList> {
            TasksScreenRoute()
        }
    }
}