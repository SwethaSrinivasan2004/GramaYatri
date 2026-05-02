package com.example.gramayatri.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.gramayatri.screens.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gramayatri.screens.LoginScreen
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
    }
}

@Composable
fun LoginScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}