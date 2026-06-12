package com.example.mvvm

import android.app.Application
import com.example.mvvm.data.local.AppDatabase
import com.example.mvvm.data.repository.TaskRepository

class TaskApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { TaskRepository(database.taskDao()) }
}
