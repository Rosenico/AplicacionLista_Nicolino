
package com.example.aplicacionlista.data

import com.example.aplicacionlista.R

data class Personaje(
    val imagenId: Int,
    val nombre: String,
    val informacion: String,
    val camino: String
)

object PersonajeData {
    val personajes = listOf(
        Personaje(R.drawable.argenti, "Argenti", "Argenti es un personaje de 5★ del elemento Físico que sigue el Camino de la Erudición.", "Erudición"),
        Personaje(R.drawable.bailu, "Bailu", "Bailu es un personaje de 5★ del elemento Rayo que sigue el Camino de la Abundancia.", "Abundancia"),
        Personaje(R.drawable.huo, "Huo Huo", "Huo Huo es un personaje de 5★ del elemento Viento que sigue el Camino de la Abundancia.", "Abundancia"),
        Personaje(R.drawable.blade, "Blade", "Blade es un personaje de 5★ del elemento Viento que sigue el Camino de la Destrucción.", "Destrucción"),
        Personaje(R.drawable.fuxuan, "Fu Xuan", "Fu Xuan es un personaje de 5★ del elemento Cuántico que sigue el Camino de la Conservación.", "Conservación"),
        Personaje(R.drawable.danhenil, "Dan Heng Invivitor Lunae", "Dan Heng • Imbibitor Lunae es un personaje de 5★ del elemento Imaginario que sigue el Camino de la Destrucción.", "Destrucción"),
        Personaje(R.drawable.jing, "Jing yuan", "Jing Yuan es un personaje de 5★ del elemento Rayo que sigue el Camino de la Erudición.", "Erudición"),
        Personaje(R.drawable.jingliu, "Jingliu", "Jingliu es un personaje de 5★ del elemento Hielo que sigue el Camino de la Destrucción.", "Destrucción"),
        Personaje(R.drawable.kafka, "Kafka", "Kafka es un personaje de 5★ del elemento Rayo que sigue el Camino de la Nihilidad.", "Nihilidad"),
        Personaje(R.drawable.luo, "Luocha", "Luocha es un personaje de 5★ del elemento Imaginario que sigue el Camino de la Abundancia.", "Abundancia"),
        Personaje(R.drawable.ratio, "Dr. Ratio", "Dr. Ratio es un personaje de 5★ del elemento Imaginario que sigue el Camino de la Cacería.", "Cacería"),
        Personaje(R.drawable.ruan, "Ruan mei", "Ruan Mei es un personaje de 5★ del elemento Hielo que sigue el Camino de la Armonía.", "Armonía"),
        Personaje(R.drawable.seele, "Seele", "Seele es un personaje de 5★ del elemento Cuántico que sigue el Camino de la Cacería.", "Cacería"),
        Personaje(R.drawable.silver, "Silver Wolf", "Silver Wolf es un personaje de 5★ del elemento Cuántico que sigue el Camino de la Nihilidad.", "Nihilidad"),
        Personaje(R.drawable.topaz, "Topaz & Numby", "Topaz & Numby es un personaje de 5★ del elemento Fuego que sigue el Camino de la Cacería.", "Cacería")
    )
}