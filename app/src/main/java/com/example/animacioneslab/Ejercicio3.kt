package com.example.animacioneslab

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Ejercicio3() {
    val expanded = remember { mutableStateOf(false) }

    val width by animateDpAsState(
        targetValue = if (expanded.value) 300.dp else 100.dp,
        animationSpec = androidx.compose.animation.core.spring(
            dampingRatio = 0.5f,
            stiffness = 100f
        )
    )

    val height by animateDpAsState(
        targetValue = if (expanded.value) 300.dp else 100.dp
    )

    val offsetX by animateDpAsState(
        targetValue = if (expanded.value) 100.dp else 0.dp
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { expanded.value = !expanded.value },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(if (expanded.value) "Contraer" else "Expandir")
        }

        Box(
            modifier = Modifier
                .offset(x = offsetX)
                .size(width, height)
                .background(Color.Red)
        )
    }
}