package com.example.heaccuatro.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppListaNombres() {
    val nombre = remember { mutableStateOf("") }
    val lista = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            label = { Text("Ingrese su nombre") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icono de persona"
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                if (nombre.value.isNotBlank()) {
                    lista.add(nombre.value)
                    nombre.value = ""
                }
            }
        ) {
            Text(text = "Agregar")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Listado de nombres y posición en la lista")
            Button(
                onClick = {
                    lista.clear()
                }
            ) {
                Text(text = "Limpiar")
            }
        }
        LazyColumn {
            itemsIndexed(lista) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item)
                    Text(text = (index + 1).toString())
                }
            }
        }
    }
}