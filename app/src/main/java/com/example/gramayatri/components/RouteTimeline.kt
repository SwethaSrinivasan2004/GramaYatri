package com.example.gramayatri.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RouteTimeline(currentIndex: Int) {

    val stops = listOf("Village A", "Village B", "Village C", "Village D")

    Column {
        stops.forEachIndexed { index, stop ->

            val color = when {
                index < currentIndex -> Color.Green
                index == currentIndex -> Color.Yellow
                else -> Color.Gray
            }

            Text(stop, color = color, modifier = Modifier.padding(8.dp))
        }
    }
}