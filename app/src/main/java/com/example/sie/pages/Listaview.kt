package com.example.sie.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.core.R

@Composable
fun UserView(navegar: NavHostController, ListaAlumnos: List<Usuarios>, AlumnoSeleccionado: MutableState<Int> ) {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5))) {
        LazyColumn(
            modifier = Modifier.weight(1f).padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(ListaAlumnos) { alumno ->
                val backgroundColor = SieLogic().ChooseCOlor(alumno.ID)
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .clickable{
                            AlumnoSeleccionado.value = alumno.ID
                            navegar.navigate("studentInfo")

                    }
                    ,
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = backgroundColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = painterResource(id = com.example.sie.R.drawable.birrete),
                            contentDescription = "Imagen Alumno",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Text(text = alumno.Nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "ID: ${alumno.ID}", fontSize = 12.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = alumno.carrera, color = Color(0xFFCE8B1A), fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = alumno.Correo, fontSize = 13.sp)
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navegar.navigate("Login") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF69340E)),
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    Text("Cerrar Sesion", fontSize = 20.sp)
                }
            }
        }
    }
}