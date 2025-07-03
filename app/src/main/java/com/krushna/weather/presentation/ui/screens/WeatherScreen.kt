package com.krushna.weather.presentation.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage

import androidx.compose.ui.layout.ContentScale
import com.krushna.weather.presentation.ui.BottomNavigationBar
import com.krushna.weather.presentation.ui.ForecastCard
import com.krushna.weather.presentation.ui.ModernSearchBar
import com.krushna.weather.presentation.ui.HeaderSection
import com.krushna.weather.presentation.ui.WeatherDetailsCard
import com.krushna.weather.presentation.ui.WeatherForecastRow
import com.krushna.weather.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    // Dummy data; later replace with viewModel
    val weatherState = remember { mutableStateOf("Foggy") }
    val temperature = remember { mutableStateOf(16) }
    val city = remember { mutableStateOf("London") }

    Box(Modifier.fillMaxSize()) {
        // Background cloud image
        AsyncImage(
            model = "https://images.unsplash.com/photo-1554629947-334ff61d85dc?q=80&w=736&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Dark gradient overlay for readability
        Box(
            Modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.6f),
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.6f)
                    )
                )
            )
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .systemBarsPadding(), // if you want safe area
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                ModernSearchBar()
                HeaderSection(city.value, temperature.value, weatherState.value)
                Spacer(Modifier.height(12.dp))
                WeatherForecastRow()
                Spacer(Modifier.height(24.dp))
                WeatherDetailsCard()
            }
            BottomNavigationBar()
        }
    }
}
