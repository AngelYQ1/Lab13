package com.example.animacioneslab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animacioneslab.ui.theme.AnimacionesLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimacionesLabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("ejercicio1") { Ejercicio1() }
        composable("ejercicio2") { Ejercicio2() }
        composable("ejercicio3") { Ejercicio3() }
        composable("ejercicio4") { Ejercicio4() }
        composable("ejercicioFinal") { EjercicioFinal() }
    }
}

@Composable
fun MenuScreen(navController: androidx.navigation.NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { navController.navigate("ejercicio1") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Ejercicio 1: AnimatedVisibility")
        }

        Button(
            onClick = { navController.navigate("ejercicio2") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Ejercicio 2: animateColorAsState")
        }

        Button(
            onClick = { navController.navigate("ejercicio3") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Ejercicio 3: Tamaño/Posición")
        }

        Button(
            onClick = { navController.navigate("ejercicio4") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Ejercicio 4: AnimatedContent")
        }

        Button(
            onClick = { navController.navigate("ejercicioFinal") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Ejercicio Final: Combinadas")
        }
    }
}