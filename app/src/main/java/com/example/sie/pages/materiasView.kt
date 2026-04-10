package com.example.sie.pages

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items


@Composable
fun MateriasView (navegar: NavHostController,  ListaAlumnos: List<Usuarios>, AlumnoSeleccionado: Int ) {
    val alumno = ListaAlumnos.find { it.ID == AlumnoSeleccionado }

    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                Text(
                    text = "Bienvenido, ${alumno?.Nombre ?: "Usuario"}",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (alumno != null) {
                items(alumno.materias) { materia ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable{
                            navegar.navigate("MisMaterias")
                        },
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(materia.nombre, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            item {
                Button(
                    onClick = { navegar.navigate("Login") },
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Text("Cerrar Sesión")
                }
            }
        }
    }
}
