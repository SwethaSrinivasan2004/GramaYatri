package com.example.gramayatriscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 🔹 Data Model
data class ActivityItem(
    val name: String,
    val message: String
)

// 🔹 Main Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityScreen(activityList: List<ActivityItem>) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Activity Feed", fontWeight = FontWeight.Bold)
                }
            )
        }
    ) { padding ->

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(8.dp)
        ) {
            items(activityList) { item ->
                ActivityCard(item)
            }
        }
    }
}

// 🔹 Individual Card UI
@Composable
fun ActivityCard(item: ActivityItem) {

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 🔵 Circle Avatar with Initial
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color(0xFF4CAF50), CircleShape)
            ) {
                Text(
                    text = item.name.first().toString(),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // 🔹 Text Content
            Column {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.message,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

// 🔹 Preview
@Preview(showBackground = true)
@Composable
fun ActivityPreview() {

    val sampleData = listOf(
        ActivityItem("Ravi", "Bus passed the stop"),
        ActivityItem("Sita", "Boarded the bus"),
        ActivityItem("Driver", "Reached next village"),
        ActivityItem("Anil", "Waiting at stop")
    )

    ActivityScreen(sampleData)
}