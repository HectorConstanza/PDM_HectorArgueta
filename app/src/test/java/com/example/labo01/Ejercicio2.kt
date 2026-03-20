package com.example.labo01

import org.junit.Test
import org.junit.Assert.*

class CalculadoraTest {


    class Calculadora(
        val marca: String,
        val anios: Int,
        var precio: Double
    ) {

        fun sumar(a: Double, b: Double): Double {
            val resultado = a + b
            println("Suma: $resultado")
            return resultado
        }

        fun restar(a: Double, b: Double): Double {
            val resultado = a - b
            println("Resta: $resultado")
            return resultado
        }

        fun multiplicar(a: Double, b: Double): Double {
            val resultado = a * b
            println("Multiplicación: $resultado")
            return resultado
        }

        fun dividir(a: Double, b: Double): Double {
            if (b == 0.0) {
                println("Error: no se puede dividir entre 0")
                return 0.0
            }
            val resultado = a / b
            println("División: $resultado")
            return resultado
        }
    }

    // ================= TEST =================

    @Test
    fun pruebaCalculadora() {

        val calc = Calculadora("Casio", 5, 25.0)


        val suma = calc.sumar(10.0, 5.0)
        val resta = calc.restar(10.0, 5.0)
        val multi = calc.multiplicar(10.0, 5.0)
        val division = calc.dividir(10.0, 5.0)


        assertEquals(15.0, suma, 0.0)
        assertEquals(5.0, resta, 0.0)
        assertEquals(50.0, multi, 0.0)
        assertEquals(2.0, division, 0.0)
    }

    @Test
    fun pruebaDivisionEntreCero() {
        val calc = Calculadora("Casio", 5, 25.0)

        val resultado = calc.dividir(10.0, 0.0)

        assertEquals(0.0, resultado, 0.0)
    }
}