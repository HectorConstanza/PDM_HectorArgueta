package com.example.mvvm.model

import java.util.Date

//Model/Task.kt
data class Task (
    val id: Int,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val isCompleted: Boolean = false
)