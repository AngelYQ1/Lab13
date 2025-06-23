package com.example.animacioneslab

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Ejercicio4() {
    val estado = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { estado.value = (estado.value + 1) % 3 },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Cambiar Estado")
        }

        AnimatedContent(
            targetState = estado.value,
            transitionSpec = {
                fadeIn() with fadeOut()
            }
        ) { target ->
            when (target) {
                0 -> Box(
                    modifier = Modifier.padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Cargando...", style = MaterialTheme.typography.headlineMedium)
                }
                1 -> Box(
                    modifier = Modifier.padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Contenido Principal", style = MaterialTheme.typography.headlineMedium)
                }
                else -> Box(
                    modifier = Modifier.padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Error!", style = MaterialTheme.typography.headlineMedium)
                }
            }
        }
    }
}