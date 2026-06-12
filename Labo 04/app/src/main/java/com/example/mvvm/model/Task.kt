package com.example.mvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

//Model/Task.kt
@Entity(tableName = "task_table")
data class Task (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val isCompleted: Boolean = false
)