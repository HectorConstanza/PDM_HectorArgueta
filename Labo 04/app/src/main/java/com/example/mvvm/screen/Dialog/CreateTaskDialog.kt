package com.example.mvvm.screen.Dialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun CreateTaskDialog(
    onDismiss: () -> Unit,
    onTaskCreated: (String, String) -> Unit
) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = {
            onDismiss()
        },

        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )

    ) {

        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Black)
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Nueva Tarea",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                },
                label = {
                    Text("Título")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
                },
                label = {
                    Text("Descripción")
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row {

                Button(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text("Cerrar")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {

                        onTaskCreated(
                            title,
                            description
                        )
                    },

                    enabled = title.isNotBlank()
                ) {

                    Text("Crear")
                }
            }
        }
    }
}