package com.example.sie.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavManagerSie(){
    val navController = rememberNavController()
    val ListaUsarios = remember { SieLogic().UserGenerator() }
    val AlumnoSeleccionado = remember { mutableStateOf(0) }


    NavHost(navController, startDestination = "Login"){
        composable("Login"){
            LoginView(navController)
        }
        composable("UserView"){
            UserView(navController, ListaUsarios,AlumnoSeleccionado)
        }
        composable("MateriasView"){
            MateriasViwe(navController)
        }
        composable("studentInfo"){
            StudentInfoView(navController, ListaUsarios,AlumnoSeleccionado.value)
        }

    }
}