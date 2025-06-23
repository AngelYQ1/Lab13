package com.example.animacioneslab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EjercicioFinal() {
    var expanded by remember { mutableStateOf(true) }
    var isBlue by remember { mutableStateOf(true) }
    var visible by remember { mutableStateOf(true) }
    var darkMode by remember { mutableStateOf(false) }
    var mainBoxVisible by remember { mutableStateOf(true) }

    val width by animateDpAsState(
        targetValue = if (expanded) 200.dp else 100.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = "widthAnimation"
    )

    val height by animateDpAsState(
        targetValue = if (expanded) 200.dp else 100.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = "heightAnimation"
    )

    val targetColor = if (isBlue) Color.Blue else Color.Magenta
    val animatedColor by animateColorAsState(
        targetValue = targetColor,
        animationSpec = spring(stiffness = Spring.StiffnessVeryLow), label = "colorAnimation"
    )

    val backgroundColor = if (darkMode) Color.DarkGray else Color.LightGray

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = mainBoxVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                Box(
                    modifier = Modifier
                        .size(width, height)
                        .background(animatedColor)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Tócame", color = Color.White)
                }
            }

            Button(
                onClick = {
                    expanded = !expanded
                    isBlue = !isBlue
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(if (expanded) "Encoger/Cambiar Color" else "Expandir/Cambiar Color")
            }

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                Button(
                    onClick = {
                        visible = false
                        mainBoxVisible = false
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Desaparecer Todo")
                }
            }

            if (!visible) {
                Button(
                    onClick = {
                        visible = true
                        mainBoxVisible = true
                        expanded = true
                        isBlue = true
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Reaparecer Todo")
                }
            }

            // Transición modo claro/oscuro
            Button(
                onClick = { darkMode = !darkMode },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(if (darkMode) "Modo Claro" else "Modo Oscuro")
            }
        }
    }
}
