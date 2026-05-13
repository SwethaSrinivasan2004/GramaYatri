package com.example.gramayatri.screens


import com.example.gramayatri.components.BottomNavBar
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.foundation.layout.navigationBarsPadding
// first version
@Composable
fun MainScreen(rootNavController: NavHostController) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) },
                modifier = Modifier.navigationBarsPadding()

    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen(rootNavController) }
            composable("alerts") { AlertsScreen() }
            composable("activity") { ActivityScreen() }
            composable("profile") { ProfileScreen(rootNavController) }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {

    val navController = rememberNavController()

    MainScreen(rootNavController = navController)
}