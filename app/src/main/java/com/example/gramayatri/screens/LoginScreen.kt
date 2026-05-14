package com.example.gramayatri.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gramayatri.shared.UserSession

@Composable
fun LoginScreen(

    navController: NavHostController
) {

    var username by remember {

        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text = "GramaYatri",
                style =
                    MaterialTheme
                        .typography
                        .headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            OutlinedTextField(

                value = username,

                onValueChange = {

                    username = it
                },

                label = {

                    Text("Enter Username")
                }
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(

                onClick = {

                    if (username.isNotBlank()) {

                        // SAVE USERNAME
                        UserSession.username =
                            username

                        navController.navigate("main")
                    }
                }
            ) {

                Text("Login")
            }
        }
    }
}