package com.example.gramayatri.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AlertsScreen() {
    AlertsContent()
}

@Composable
fun AlertsContent() {
    Text("⚠️ Bus canceled today\n🕒 Delayed 20 mins")
}

@Preview(showBackground = true)
@Composable
fun AlertsPreview() {
    AlertsContent()
}