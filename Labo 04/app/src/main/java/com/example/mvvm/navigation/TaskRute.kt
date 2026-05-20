package com.example.mvvm.navigation

sealed class AppScreens(val route: String) {

    data object Tasks : AppScreens("tasks")
    data object Home : AppScreens("home")

}