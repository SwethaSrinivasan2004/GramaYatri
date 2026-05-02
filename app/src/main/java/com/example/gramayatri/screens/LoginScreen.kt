package com.example.gramayatri.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview
import com.example.gramayatri.ui.theme.GramaYatriTheme

// -------------------- MAIN SCREEN --------------------

@Composable
fun LoginContent(onLoginClick: () -> Unit) {

    var username by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    // 👇 ADD HERE (after phone)
    val isValid = phone.length == 10

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Welcome",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                placeholder = { Text("+91 Mobile Number") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 👇 MODIFY BUTTON HERE
            Button(
                onClick = onLoginClick,
                enabled = isValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isValid) Color(0xFF2E7D32) else Color.LightGray
                )
            ) {
                Text("LOGIN", color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    GramaYatriTheme {
        LoginContent(onLoginClick = {})
    }
}

annotation class LoginScreen
