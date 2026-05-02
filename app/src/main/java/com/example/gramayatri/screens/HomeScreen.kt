package com.example.gramayatri.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(navController: NavHostController) {
    HomeScreenContent {
        navController.navigate("route")
    }
}

@Composable
fun HomeScreenContent(onRouteClick: () -> Unit) {
    val routes = listOf("Village A → Town B", "Village C → City D")

    Column(Modifier.padding(16.dp)) {
        Text("Select Route", fontSize = 22.sp)

        routes.forEach {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onRouteClick() }
            ) {
                Text(it, Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreenContent {}
}