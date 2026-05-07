package com.example.heaccuatro.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavegacionPrincipal() { // Cambiamos el nombre para evitar el error
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Labo 03") }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {

                IconButton(onClick = { navController.navigate(home) }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = "Home")
                }
                IconButton(onClick = { navController.navigate(nombres) }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = "Nombres")
                }
                IconButton(onClick = { navController.navigate(sensor) }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Lock, contentDescription = "Sensor")
                }
            }
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController, startDestination = home) {
                composable<home> {
                    PantallaInicio()
                }
                composable<nombres> {
                    AppListaNombres()
                }
                composable<sensor> {
                    GyroscopeSensor()
                }
            }
        }
    }
}

@Composable
fun PantallaInicio() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido a la App", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Usa el menú inferior para navegar")
    }
}