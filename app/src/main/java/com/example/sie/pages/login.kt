package com.example.sie.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sie.R

@Composable

fun LoginView (navegar: NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var MensajError by remember { mutableStateOf("")}
    Column(modifier = Modifier.fillMaxSize().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.sie), contentDescription = null, modifier = Modifier.size(120.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo :")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID :") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            MensajError = ""
            val idInt = id.toIntOrNull()

            if (idInt == null) {
                MensajError = "Por favor, ingresa un ID numérico válido"
            } else {
                try {
                    val acceso = SieLogic().LoginBy(idInt)
                    if (acceso) {
                        val tipoUsuario = SieLogic().UserType(idInt)
                        if (tipoUsuario == "coordinador"){
                            navegar.navigate("UserView")
                        } else if (tipoUsuario == "estudiante") {
                            navegar.navigate("MateriasView")
                        }
                    } else {
                        MensajError = "ID no reconocido. No tienes acceso."
                    }
                } catch (e: Exception) {
                    MensajError = "Error inesperado: ${e.localizedMessage}"
                }
            }
        }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF69340E)), modifier = Modifier.fillMaxWidth().height(50.dp)) {
            Text("Iniciar sesión", fontSize = 20.sp)
        }
        Text("${MensajError}", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(30.dp))
        Image(painter = painterResource(id = R.drawable.iest), contentDescription = null, modifier = Modifier.size(90.dp))
    }
}