package com.example.aplicacionlista.ventanas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aplicacionlista.data.PersonajeData
import com.example.aplicacionlista.ui.theme.AplicacionLista

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionLista {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(navController = navController)
                        }
                        composable(
                            route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { backStackEntry ->
                            val index = backStackEntry.arguments?.getInt("index")
                            if (index != null) {
                                DetailScreen(
                                    personajes = PersonajeData.personajes,
                                    itemIndex = index
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}