package com.example.coleramsey_comp304lab3_ex.repositories

import com.example.coleramsey_comp304lab3_ex.data.api.WeatherApiService
import com.example.coleramsey_comp304lab3_ex.data.models.WeatherResponse

class WeatherRepository(private val apiService: WeatherApiService) {

    suspend fun fetchWeatherByCoordinates(lat: Double, lon: Double, apiKey: String): WeatherResponse {
        return apiService.getCurrentWeatherByCoordinates(lat, lon, apiKey)
    }
}