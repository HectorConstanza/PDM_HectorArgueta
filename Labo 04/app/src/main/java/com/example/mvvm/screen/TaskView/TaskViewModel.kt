package com.example.mvvm.screen.TaskView

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.Task

class TaskViewModel : ViewModel() {

    private val _taskList = mutableStateListOf<Task>()
    val taskList: List<Task> = _taskList

    fun addTask(title: String, description: String) {

        val newTask = Task(
            id = _taskList.size + 1,
            title = title,
            description = description
        )

        _taskList.add(newTask)
    }
}