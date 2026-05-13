package com.example.gramayatri.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import com.example.gramayatri.shared.routeStops

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouteScreen() {

    // current bus position
    var currentStopIndex by remember { mutableStateOf(0) }

    // notification banner
    var notification by remember {
        mutableStateOf("Bus currently at Village A")
    }

    // calculate ETA
    fun calculateETA(targetIndex: Int): Int {

        var total = 0

        for (i in currentStopIndex + 1..targetIndex) {
            total += routeStops[i].travelTimeFromPrevious
        }

        return total
    }

    // simulate ping update
    fun moveBusForward() {

        if (currentStopIndex < routeStops.lastIndex) {

            currentStopIndex++

            notification =
                "Bus reached ${routeStops[currentStopIndex].name}"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // title
        Text(
            text = "Live Route ETA",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // notification banner
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "🔔 $notification",
                modifier = Modifier.padding(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // route list
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            itemsIndexed(routeStops) { index, stop ->

                val statusText =
                    when {

                        index < currentStopIndex ->
                            "Passed"

                        index == currentStopIndex ->
                            "Bus Here"

                        else ->
                            "ETA ${calculateETA(index)} mins"
                    }

                val color =
                    when {

                        index < currentStopIndex ->
                            Color.Gray

                        index == currentStopIndex ->
                            Color(0xFF2E7D32)

                        else ->
                            Color.Black
                    }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {

                            Text(
                                text = stop.name,
                                fontWeight = FontWeight.Bold,
                                color = color
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(statusText)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ping button
        Button(
            onClick = {
                moveBusForward()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ping Bus")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoutePreview() {
    MaterialTheme {
        RouteScreen()
    }
}