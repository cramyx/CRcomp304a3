package com.example.coleramsey_comp304lab3_ex.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coleramsey_comp304lab3_ex.ui.screens.HomePage
import com.example.coleramsey_comp304lab3_ex.ui.screens.LocationPage
import com.example.coleramsey_comp304lab3_ex.viewmodels.WeatherViewModel

@Composable
fun WeatherApp(viewModel: WeatherViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomePage(navController, viewModel) }
        composable("location/{locationName}") { backStackEntry ->
            val locationName = backStackEntry.arguments?.getString("locationName") ?: "Unknown"
            LocationPage(locationName, viewModel, navController)
        }
    }
}