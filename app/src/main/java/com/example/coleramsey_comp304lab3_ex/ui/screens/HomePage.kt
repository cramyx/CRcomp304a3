package com.example.coleramsey_comp304lab3_ex.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coleramsey_comp304lab3_ex.viewmodels.WeatherViewModel

@Composable
fun HomePage(navController: NavController, viewModel: WeatherViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AppTitleRow()
        Spacer(modifier = Modifier.height(8.dp))
        CitiesSectionHeader()
        Spacer(modifier = Modifier.height(16.dp))
        val locations = listOf(
            Triple("Toronto", 43.7, -79.42),
            Triple("New York", 40.7, -74.0),
            Triple("London", 51.5, -0.1),
            Triple("Miami", 25.76, -80.19),
            Triple("Dallas", 32.77, -96.79),
            Triple("San Diego", 32.71, -117.16),
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            items(locations) { (name, lat, lon) ->
                val weather = viewModel.weatherDataMap[name]

                LaunchedEffect(name) {
                    viewModel.fetchWeatherByCoordinates(name, lat, lon, "0062acb790ecd662d7273b6d9ba31f5e")
                }

                WeatherCard(
                    locationName = name,
                    temperature = weather?.main?.temp,
                    onClick = { navController.navigate("location/$name") }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Click on a city card above to view more weather information.",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun WeatherCard(locationName: String, temperature: Double?, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = locationName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = temperature?.let { "${it}°C" } ?: "Loading...",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}