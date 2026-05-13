package com.example.gramayatri.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

// -------------------- MAIN SCREEN --------------------

@Composable
fun AlertsScreen() {
    AlertsContent()
}

// -------------------- DATA MODEL --------------------

data class Alert(
    val message: String,
    val time: String,
    val type: AlertType
)

enum class AlertType {
    CANCELLED, DELAY, INFO
}

// -------------------- UI CONTENT --------------------

@Composable
fun AlertsContent() {

    val alerts = com.example.gramayatri.shared.AppState.alerts

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(alerts) { alert ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(alert.message)
                    Text(alert.time, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
// -------------------- ALERT CARD --------------------

@Composable
fun AlertCard(alert: Alert) {

    val (color, icon) = when (alert.type) {
        AlertType.CANCELLED -> Color(0xFFD32F2F) to "⚠️"
        AlertType.DELAY -> Color(0xFFF9A825) to "⏱️"
        AlertType.INFO -> Color(0xFF388E3C) to "ℹ️"
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = color.copy(alpha = 0.1f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = icon,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = alert.message,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = alert.time,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

// -------------------- PREVIEW --------------------

@Preview(showBackground = true)
@Composable
fun AlertsPreview() {
    AlertsContent()
}