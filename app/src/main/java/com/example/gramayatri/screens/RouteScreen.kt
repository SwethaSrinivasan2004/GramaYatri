package com.example.gramayatri.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.navigationBarsPadding
import com.example.gramayatri.data.FirebaseRepository
import com.example.gramayatri.shared.UserSession
import com.example.gramayatri.shared.routeStops

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouteScreen() {

    var showSheet by remember {

        mutableStateOf(false)
    }

    var notification by remember {

        mutableStateOf(
            "Bus currently at Village A"
        )
    }

    var currentStopIndex by remember {

        mutableStateOf(0)
    }

    // delay dialog
    var showDelayDialog by remember {

        mutableStateOf(false)
    }

    var enteredDelay by remember {

        mutableStateOf("")
    }

    // total delay
    var delayMinutes by remember {

        mutableStateOf(0)
    }

    // ETA calculation
    fun calculateETA(
        targetIndex: Int
    ): Int {

        var total = 0

        for (
        i in currentStopIndex + 1..targetIndex
        ) {

            total +=
                routeStops[i]
                    .travelTimeFromPrevious
        }

        // add delay
        total += delayMinutes

        return total
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .navigationBarsPadding()
    ) {

        Text(
            text = "Live Route ETA",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme
                        .colorScheme
                        .primaryContainer
            ),

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "🔔 $notification",
                modifier = Modifier.padding(12.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            itemsIndexed(routeStops) {

                    index,
                    stop ->

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

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = stop.name,
                            fontWeight = FontWeight.Bold,
                            color = color
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(statusText)
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(

            onClick = {

                showSheet = true
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Ping Bus")
        }
    }

    // ---------------- BOTTOM SHEET ----------------

    if (showSheet) {

        ModalBottomSheet(

            onDismissRequest = {

                showSheet = false
            }
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Report Bus Status",
                    style =
                        MaterialTheme
                            .typography
                            .titleMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                // ---------------- BOARD BUS ----------------

                Button(

                    onClick = {

                        FirebaseRepository.sendActivity(

                            user =
                                UserSession.username,

                            message =
                                "Boarded the bus",

                            type = "BOARD"
                        )

                        // move bus
                        if (
                            currentStopIndex <
                            routeStops.lastIndex
                        ) {

                            currentStopIndex++
                        }

                        notification =
                            "🚌 Bus reached ${
                                routeStops[
                                    currentStopIndex
                                ].name
                            }"

                        showSheet = false
                    },

                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text("Boarded Bus")
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                // ---------------- BUS PASSED ----------------

                Button(

                    onClick = {

                        FirebaseRepository.sendActivity(

                            user =
                                UserSession.username,

                            message =
                                "Bus passed stop",

                            type = "PASS"
                        )

                        notification =
                            "🚌 Bus passed stop"

                        showSheet = false
                    },

                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text("Bus Passed")
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                // ---------------- DELAY ----------------

                Button(

                    onClick = {

                        showDelayDialog = true
                    },

                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text("Bus Delayed")
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                // ---------------- CANCEL ----------------

                Button(

                    onClick = {

                        FirebaseRepository.sendActivity(

                            user =
                                UserSession.username,

                            message =
                                "Bus cancelled today",

                            type = "CANCEL"
                        )

                        notification =
                            "❌ Bus cancelled today"

                        showSheet = false
                    },

                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text("Bus Cancelled")
                }
            }
        }
    }

    // ---------------- DELAY INPUT DIALOG ----------------

    if (showDelayDialog) {

        AlertDialog(

            onDismissRequest = {

                showDelayDialog = false
            },

            title = {

                Text("Delay Duration")
            },

            text = {

                OutlinedTextField(

                    value = enteredDelay,

                    onValueChange = {

                        enteredDelay = it
                    },

                    label = {

                        Text("Delay in minutes")
                    }
                )
            },

            confirmButton = {

                Button(

                    onClick = {

                        delayMinutes =
                            enteredDelay
                                .toIntOrNull()
                                ?: 0

                        FirebaseRepository.sendActivity(

                            user =
                                UserSession.username,

                            message =
                                "Bus delayed by $delayMinutes mins",

                            type = "DELAY"
                        )

                        notification =
                            "⚠️ Bus delayed by $delayMinutes mins"

                        showDelayDialog = false

                        showSheet = false
                    }
                ) {

                    Text("Confirm")
                }
            }
        )
    }
}