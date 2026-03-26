package com.example.labo01

import org.junit.Test

class EstudianteTest {

    // Clase simple
    class Estudiante(
        var nombre: String,
        var carnet: String,
        var asignatura: String
    )

    @Test
    fun pruebaEstudiantes() {

        val Ciclo01 = mutableListOf<Estudiante>()


        Ciclo01.add(Estudiante("Juan", "001", "Programacion de Dispositivos Moviles"))
        Ciclo01.add(Estudiante("Maria", "002", "Programacion de Dispositivos Moviles"))
        Ciclo01.add(Estudiante("Carlos", "003", "Programacion de Dispositivos Moviles"))


        Ciclo01.add(Estudiante("Ana", "004", "Analisis Numerico"))
        Ciclo01.add(Estudiante("Luis", "005", "Analisis Numerico"))
        Ciclo01.add(Estudiante("Sofia", "006", "Analisis Numerico"))
        Ciclo01.add(Estudiante("Pedro", "007", "Analisis Numerico"))

        println("Estudiantes de Programacion de Dispositivos Moviles:")


        for (est in Ciclo01) {
            if (est.asignatura == "Programacion de Dispositivos Moviles") {
                println("Nombre: ${est.nombre} - Carnet: ${est.carnet}")
            }
        }
    }
}