package com.example.coleramsey_comp304lab3_ex.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coleramsey_comp304lab3_ex.viewmodels.WeatherViewModel

@Composable
fun LocationPage(locationName: String, viewModel: WeatherViewModel, navController: NavController) {
    val weather = viewModel.weatherDataMap[locationName]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppTitleRow()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Location: $locationName",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (weather != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Current Temp: ${weather.main.temp}°C", fontSize = 18.sp)
                    Text("Feels Like: ${weather.main.feels_like}°C", fontSize = 18.sp)
                    Text("Humidity: ${weather.main.humidity}%", fontSize = 18.sp)
                }
            }
        } else {
            Text("Loading weather data...", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Back to Home", fontSize = 16.sp)
        }
    }
}