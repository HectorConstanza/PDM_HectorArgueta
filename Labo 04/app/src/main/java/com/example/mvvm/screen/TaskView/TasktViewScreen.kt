package com.example.mvvm.screen.TaskView
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm.screen.TaskView.TaskViewModel
import com.example.mvvm.screen.Dialog.CreateTaskDialog
import com.example.mvvm.screen.card.TaskCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    taskViewModel: TaskViewModel
) {

    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Tasks List")
                }
            )
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {

            items(taskViewModel.taskList) { task ->

                TaskCard(task)

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        if (showDialog) {

            CreateTaskDialog(

                onDismiss = {
                    showDialog = false
                },

                onTaskCreated = { title, description ->

                    taskViewModel.addTask(
                        title,
                        description
                    )

                    showDialog = false
                }
            )
        }
    }
}