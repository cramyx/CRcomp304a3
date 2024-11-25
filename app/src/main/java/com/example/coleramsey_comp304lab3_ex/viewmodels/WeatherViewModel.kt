package com.example.coleramsey_comp304lab3_ex.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coleramsey_comp304lab3_ex.data.models.WeatherResponse
import com.example.coleramsey_comp304lab3_ex.repositories.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherDataMap = mutableStateMapOf<String, WeatherResponse?>()
    val weatherDataMap: Map<String, WeatherResponse?> get() = _weatherDataMap

    fun fetchWeatherByCoordinates(cityName: String, lat: Double, lon: Double, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = repository.fetchWeatherByCoordinates(lat, lon, apiKey)
                _weatherDataMap[cityName] = response
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Error fetching weather for $cityName: ${e.message}", e)
                _weatherDataMap[cityName] = null
            }
        }
    }
}