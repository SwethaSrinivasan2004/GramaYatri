package com.example.gramayatri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gramayatri.navigation.AppNavigation
import com.example.gramayatri.ui.theme.GramaYatriTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            GramaYatriTheme {
                AppNavigation()
            }
        }
    }
}