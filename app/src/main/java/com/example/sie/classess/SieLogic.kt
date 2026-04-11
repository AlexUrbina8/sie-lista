package com.example.sie.classess

import androidx.compose.ui.graphics.Color
import com.example.sie.classess.Usuarios

class SieLogic {
    val usuariosRegistrados = UserGenerator()
    fun LoginBy(idRecibido: Int): Usuarios? {
        for (usuarios in usuariosRegistrados) {
            if (usuarios.ID == idRecibido) {
                return usuarios
            }
        }
        return null
    }
    fun ChooseCOlor(id: Int): Color {
        return if (id % 2 == 0){
            Color(0xFF7EC1F5)
        }else{
            Color.Companion.White
        }

    }

    fun UserGenerator(): List<Usuarios>{
        var userLista = mutableListOf<Usuarios>()

        userLista.add(
            Usuarios(
                ID = 20829,
                Nombre = "Luis Alejandro Urbina Gómez",
                nivel = "estudiante",
                Correo = "luis.urbina@iest.edu.mx",
                carrera = "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
                gustos = "Desarrollo de videojuegos y Piano",
                materias = listOf(
                    Materias("Programación Móvil", 9.5, 9.2, 2),
                    Materias("Bases de Datos", 8.0, 8.5, 0),
                    Materias("Cálculo Integral", 10.0, 9.8, 1)
                )
            )
        )

        userLista.add(
            Usuarios(
                ID = 23388,
                Nombre = "Juan Carlos Seidller Ferniza",
                nivel = "estudiante",
                Correo = "juan.seidller@iest.edu.mx",
                carrera = "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
                gustos = "Programacion",
                materias = listOf(
                    Materias("Análisis de Datos", 9.0, 8.8, 1),
                    Materias("Estructura de Datos", 7.5, 8.0, 4),
                    Materias("Contabilidad", 10.0, 9.5, 0)
                )

            )
        )

        userLista.add(
            Usuarios(
                ID = 23389,
                Nombre = "Roman Del Angel Juarez",
                nivel = "estudiante",
                Correo = "roman.delangel@iest.edu.mx",
                carrera = "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
                gustos = "Ver series de Sci-Fi y Gimnasio",
                materias = listOf(
                    Materias("Programación Móvil", 9.5, 9.2, 2),
                    Materias("Bases de Datos", 8.0, 8.5, 0),
                    Materias("Cálculo Integral", 10.0, 9.8, 1)
                )
            )
        )


        userLista.add(
            Usuarios(
                ID = 23534,
                Nombre = "Benjamin Lobato ",
                nivel = "estudiante",
                Correo = "benjamin.lobato@iest.edu.mx",
                carrera = "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
                gustos = "Aprender idiomas y Programar en Python",
                materias = listOf(
                    Materias("Programación Móvil", 9.5, 9.2, 2),
                    Materias("Bases de Datos", 8.0, 8.5, 0),
                    Materias("Cálculo Integral", 10.0, 9.8, 1)
                )
            )
        )

        userLista.add(
            Usuarios(
                ID = 23639,
                Nombre = "Omar Novella ",
                nivel = "estudiante",
                Correo = "omar.novella@iest.edu.mx",
                carrera = "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
                gustos = "Escuchar Podcasts y Tocar Guitarra",
                materias = listOf(
                    Materias("Programación Móvil", 9.5, 9.2, 2),
                    Materias("Bases de Datos", 8.0, 8.5, 0),
                    Materias("Cálculo Integral", 10.0, 9.8, 1)
                )
            )
        )


        userLista.add(
            Usuarios(
                ID = 6,
                Nombre = "Alexandro Barron Guajardo",
                nivel = "coordinador",
                Correo = "alex.barron@iest.edu.mx",
                carrera = "Coordinador de Sistemas",
                gustos = "Tecnología",
                materias = emptyList()
            )
        )

        return userLista

    }
}