package com.krushna.weather.presentation.ui

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.krushna.weather.presentation.viewmodel.WeatherUiState

fun rememberWeatherBackground(uiState: WeatherUiState): Brush {
    return when (uiState) {
        is WeatherUiState.Success -> {
            when {
                uiState.weatherData.description.contains("rain", true) ->
                    Brush.verticalGradient(listOf(Color(0xFF4E5D6A), Color(0xFF2C3E50)))
                uiState.weatherData.description.contains("cloud", true) ->
                    Brush.verticalGradient(listOf(Color(0xFFBDC3C7), Color(0xFF2C3E50)))
                uiState.weatherData.description.contains("clear", true) ->
                    Brush.verticalGradient(listOf(Color(0xFF56CCF2), Color(0xFF2F80ED)))
                else ->
                    Brush.verticalGradient(listOf(Color(0xFF56CCF2), Color(0xFF2F80ED)))
            }
        }
        else -> Brush.verticalGradient(listOf(Color(0xFF56CCF2), Color(0xFF2F80ED)))
    }
}
