package com.example.mvvm.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.screen.TaskView.TaskScreen
import com.example.mvvm.screen.TaskView.TaskViewModel
import com.example.mvvm.screen.home.HomeScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val taskViewModel: TaskViewModel = viewModel(
        factory = TaskViewModel.Factory
    )

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {

            HomeScreen(
                navController = navController
            )
        }

        composable(AppScreens.Tasks.route) {

            TaskScreen(
                taskViewModel = taskViewModel

            )
        }
    }
}