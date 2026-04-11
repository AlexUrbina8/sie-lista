package com.example.sie.classess

data class Usuarios(
    val ID:Int,
    val nivel: String,
    val Nombre: String,
    val Correo: String,
    val carrera: String,
    val gustos: String,
    val materias: List<Materias>
)