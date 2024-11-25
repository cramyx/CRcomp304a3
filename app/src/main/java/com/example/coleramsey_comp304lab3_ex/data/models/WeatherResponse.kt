package com.example.coleramsey_comp304lab3_ex.data.models

data class WeatherResponse(
    val main: MainWeather,
    val name: String
)

data class MainWeather(
    val temp: Double,
    val feels_like: Double,
    val humidity: Int
)