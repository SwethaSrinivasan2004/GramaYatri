package com.example.gramayatri.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gramayatri.data.FirebaseRepository
import com.example.gramayatri.models.ActivityItem
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AlertsScreen() {

    var alerts by remember {

        mutableStateOf(
            listOf<ActivityItem>()
        )
    }

    LaunchedEffect(Unit) {

        FirebaseRepository.listenForActivities {

            // FILTER ONLY ALERTS
            alerts = it.filter { item ->

                item.type == "DELAY" ||
                        item.type == "CANCEL"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Live Alerts",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (alerts.isEmpty()) {

            Text("No alerts right now")
        }

        LazyColumn {

            items(alerts) { item ->

                val formattedTime =

                    SimpleDateFormat(
                        "hh:mm a",
                        Locale.getDefault()
                    ).format(Date(item.timestamp))

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme
                                .colorScheme
                                .errorContainer
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = item.message,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = item.type
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = formattedTime,
                            style =
                                MaterialTheme
                                    .typography
                                    .bodySmall
                        )
                    }
                }
            }
        }
    }
}