package com.example.labo01

import org.junit.Test
import org.junit.Assert.*

class ComputadoraTest {

    class Programa(var nombre: String)

    class Computadora(
        var marca: String,
        var procesador: String,
        var ram: Int,
        var almacenamiento: Int,
        var sistemaOperativo: String,
        var programasInstalados: MutableList<Programa>
    ) {

        fun encender() {
            println("La computadora está encendida")
        }

        fun apagar() {
            println("La computadora está apagada")
        }

        fun actualizarRAM(nuevaRAM: Int) {
            ram = nuevaRAM
            println("RAM actualizada a $ram GB")
        }

        fun actualizarAlmacenamiento(nuevo: Int) {
            almacenamiento = nuevo
            println("Almacenamiento actualizado a $almacenamiento GB")
        }

        fun cambiarSO(nuevoSO: String) {
            sistemaOperativo = nuevoSO
            println("Nuevo sistema operativo: $sistemaOperativo")
        }

        fun filtrarProgramas(anio: String): List<Programa> {
            val lista = mutableListOf<Programa>()

            for (programa in programasInstalados) {
                if (programa.nombre.contains(anio)) {
                    lista.add(programa)
                }
            }

            println("Programas del año $anio:")
            for (p in lista) {
                println(p.nombre)
            }

            return lista
        }
    }

    // ================= TESTS =================

    @Test
    fun pruebaGeneral() {

        val programas = mutableListOf(
            Programa("Notion 2026"),
            Programa("Facebook 2024"),
            Programa("VSCode 2026")
        )

        val pc = Computadora(
            "Dell",
            "i7",
            8,
            512,
            "Windows 10",
            programas
        )


        pc.encender()
        pc.apagar()


        pc.actualizarRAM(16)
        pc.actualizarAlmacenamiento(1000)
        pc.cambiarSO("Windows 11")


        val resultado = pc.filtrarProgramas("2026")


        assertEquals(2, resultado.size)
    }
}