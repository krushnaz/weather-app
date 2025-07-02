package com.krushna.weather.presentation.viewmodel

import com.krushna.weather.presentation.model.WeatherData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

sealed class WeatherUiState {
    object Empty : WeatherUiState()
    object Loading : WeatherUiState()
    data class Success(val weatherData: WeatherData) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}

class WeatherViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Empty)
    val uiState: StateFlow<WeatherUiState> = _uiState

    init {
        // fetch weather for default city when ViewModel is created
        getWeather("Pune")
    }

    fun getWeather(city: String) {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading
            try {
                // Simulate network delay & fake data
                delay(1000)
                val fakeData = WeatherData(
                    city = city,
                    temperature = 28.5,
                    description = "Sunny"
                )
                _uiState.value = WeatherUiState.Success(fakeData)
            } catch (e: Exception) {
                _uiState.value = WeatherUiState.Error("Failed to load weather: ${e.message}")
            }
        }
    }
}
