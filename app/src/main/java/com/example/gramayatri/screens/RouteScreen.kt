package com.example.gramayatri.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.gramayatri.components.RouteTimeline

@Composable
fun RouteScreen() {
    var index by remember { mutableStateOf(0) }
    var eta by remember { mutableStateOf(30) }

    RouteScreenContent(
        currentIndex = index,
        eta = eta,
        onPing = {
            if (index < 3) {
                index++
                eta -= 10
            }
        }
    )
}

@Composable
fun RouteScreenContent(currentIndex: Int, eta: Int, onPing: () -> Unit) {

    Column(Modifier.padding(16.dp)) {

        Text("Bus arriving in ~$eta mins", fontSize = 20.sp)
        Text("Reported by Ravi")

        Spacer(Modifier.height(16.dp))

        RouteTimeline(currentIndex)

        Spacer(Modifier.weight(1f))

        Button(onClick = onPing, modifier = Modifier.fillMaxWidth()) {
            Text("Ping Bus")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoutePreview() {
    RouteScreenContent(1, 20) {}
}