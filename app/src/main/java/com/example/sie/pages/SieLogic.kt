package com.example.sie.pages

import androidx.compose.ui.graphics.Color

class SieLogic {

    fun LoginBy(id: Int): Boolean{
        return when(id){
            in 1..11 -> true
            in 12 .. 20049 -> false
            in 20050..20200 -> true
            else -> false
        }
    }

    fun UserType(id: Int): String{
        return when(id){
            in 1..11 -> "coordinador"
            in 12 .. 20049 -> ""
            in 20050..20200 -> "estudiante"
            else -> ""
        }
    }

    fun ChooseCOlor(id: Int): Color{
        return if (id % 2 == 0){
            Color(0xFF7EC1F5)
        }else{
            Color.White
        }

    }

    fun UserGenerator(): List<Usuarios>{
        var userLista = mutableListOf<Usuarios>()

        userLista.add(Usuarios(
            ID= 20829,
            Nombre= "Luis Alejandro Urbina Gómez",
            nivel = "estudiante",
            Correo= "luis.urbina@iest.edu.mx",
            carrera= "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
            gustos= "Hola"
            )
        )

        userLista.add(Usuarios(
            ID= 23388,
            Nombre= "Juan Carlos Seidller Ferniza",
            nivel = "estudiante",
            Correo= "juan.seidller@iest.edu.mx",
            carrera= "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
            gustos= "Hola"
            )
        )

        userLista.add(Usuarios(
            ID= 23389,
            Nombre= "Roman Del Angel Juarez",
            nivel = "estudiante",
            Correo= "roman.delangel@iest.edu.mx",
            carrera= "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
            gustos= "Hola"
            )
        )


        userLista.add(Usuarios(
            ID= 23534,
            Nombre= "Benjamin Lobato ",
            nivel = "estudiante",
            Correo= "benjamin.lobato@iest.edu.mx",
            carrera= "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
            gustos= "Hola"
            )
        )

        userLista.add(Usuarios(
            ID= 23639,
            Nombre= "Omar Novella ",
            nivel = "estudiante",
            Correo= "omar.novella@iest.edu.mx",
            carrera= "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
            gustos= "Hola"
            )
        )



//        userLista.add(Usuarios(
//            ID= 6,
//            Nombre= "Alexandro Barron Guajardo",
//            nivel = "coordinador",
//            Correo= "alex.barron@iest.edu.mx",
//            carrera= "Licenciatura en Ingenieria en Sistemas y Negocios Digitales (Plan 2022)",
//            gustos= "Hola"
//        )
        //)

        return userLista

    }
}