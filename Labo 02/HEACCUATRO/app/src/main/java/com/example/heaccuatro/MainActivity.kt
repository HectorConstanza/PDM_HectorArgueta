package com.example.heaccuatro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.heaccuatro.ui.theme.HEACCUATROTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HEACCUATROTheme {
                AppListaNombres()
            }
        }
    }
}

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
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Listado de nombres y posición en la lista",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { lista.clear() }
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