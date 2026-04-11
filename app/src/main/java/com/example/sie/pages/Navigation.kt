package com.example.sie.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sie.classess.Materias
import com.example.sie.classess.SieLogic
import com.example.sie.pages.alumno.InfoMateria
import com.example.sie.pages.alumno.MateriasView
import com.example.sie.pages.coord.StudentInfoView
import com.example.sie.pages.coord.UserView

@Composable
fun NavManagerSie(){
    val navController = rememberNavController()
    val ListaUsarios = remember { SieLogic().UserGenerator() }
    val AlumnoSeleccionado = remember { mutableStateOf(0) }
    val MateriaSeleccionada = remember { mutableStateOf<Materias?>(null) }

    NavHost(navController, startDestination = "Login"){
        composable("Login"){
            LoginView(navController,AlumnoSeleccionado)
        }
        composable("ListaView"){
            UserView(navController, ListaUsarios, AlumnoSeleccionado)
        }
        composable("studentInfo"){
            StudentInfoView(navController, ListaUsarios, AlumnoSeleccionado.value)
        }
        composable("MateriasView"){
            MateriasView(navController, ListaUsarios, AlumnoSeleccionado.value,MateriaSeleccionada)
        }
        composable("infoMateria"){
            InfoMateria(navController,MateriaSeleccionada.value)
        }

    }
}