package com.example.aplicacionlista.ventanas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionlista.data.Personaje

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    personajes: List<Personaje>,
    itemIndex: Int?
) {
    val personaje = personajes[itemIndex ?: 0]

    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = personaje.imagenId),
                contentDescription = personaje.nombre,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        }
        Text(text = personaje.nombre, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = personaje.informacion, fontSize = 18.sp)
    }
}