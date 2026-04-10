package com.example.sie.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun StudentInfoView (navegar: NavHostController, listaAlumnos: List<Usuarios>,idSeleccionado: Int) {
    val alumno = listaAlumnos.find { it.ID == idSeleccionado }
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn() {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        if (alumno != null) {
                            Text("Información de: ${alumno.Nombre}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Carrera: ${alumno.carrera}")
                            Text("Correo: ${alumno.Correo}")
                            Text("Pasatiempo: ${alumno.gustos}")
                        } else {
                            Text("Alumno no encontrado")
                        }
                    }
                }
            }

            item {
                Button(
                    onClick = { navegar.navigate("UserView") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF69340E)),
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    Text("Regresar", fontSize = 20.sp)
                }
            }
        }
    }
}