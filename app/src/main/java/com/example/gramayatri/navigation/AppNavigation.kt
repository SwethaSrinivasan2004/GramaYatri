package com.example.gramayatri.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.gramayatri.screens.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("main") {
            MainScreen(navController)
        }

        composable("route") {
            RouteScreen()
        }

        composable("activity") {
            ActivityScreen()
        }

        composable("alerts") {
            AlertsScreen()
        }
    }
}