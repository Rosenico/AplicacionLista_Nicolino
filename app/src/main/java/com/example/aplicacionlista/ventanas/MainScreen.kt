package com.example.aplicacionlista.ventanas
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aplicacionlista.data.Personaje
import com.example.aplicacionlista.data.PersonajeData
import kotlinx.coroutines.delay

@Composable
fun rainbowColors(): State<List<Color>> {
    return remember {
        mutableStateOf(
            listOf(
                Color.Red,
                Color(0xFFFF7F00),  // Orange
                Color.Yellow,
                Color.Green,
                Color.Blue,
                Color(0x8B00FF)     // Indigo
            )
        )
    }
}

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val personajes = PersonajeData.personajes

        items(personajes.size) { index ->
            ColumnItem(
                modifier,
                personaje = personajes[index],
                navController = navController
            )
        }
    }
}@Composable
fun ColumnItem(
    modifier: Modifier,
    personaje: Personaje,
    navController: NavController
) {
    var colorIndex by remember { mutableStateOf(0) }

    val rainbowColorsState = rainbowColors()
    val animatedColor = animateColorAsState(rainbowColorsState.value[colorIndex]).value

    LaunchedEffect(colorIndex) {
        while (true) {
            delay(400)
            colorIndex = (colorIndex + 1) % rainbowColorsState.value.size
        }
    }

    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = "DetailScreen/${PersonajeData.personajes.indexOf(personaje)}")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clipToBounds(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = personaje.imagenId),
                contentDescription = personaje.nombre,
                modifier = Modifier.size(140.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = personaje.nombre,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = animatedColor
                )
                Text(text = personaje.informacion, fontSize = 18.sp)
                Text(text = "Camino: ${personaje.camino}", fontSize = 16.sp)
            }
        }
    }
}
