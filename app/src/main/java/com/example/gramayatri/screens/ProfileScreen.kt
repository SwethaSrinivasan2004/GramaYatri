package com.example.gramayatri.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen(navController: NavHostController) {
    ProfileContent {
        navController.navigate("login")
    }
}

@Composable
fun ProfileContent(onLogout: () -> Unit) {
    Column {
        Text("Demo User")
        Button(onClick = onLogout) {
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileContent {}
}