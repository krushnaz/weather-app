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
import com.krushna.weather.presentation.ui.EventCardsSection
import com.krushna.weather.presentation.ui.GlassySearchBar
import com.krushna.weather.presentation.ui.HeaderSection
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
            model = "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0",
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
                HeaderSection(city.value, temperature.value, weatherState.value)
                Spacer(Modifier.height(12.dp))
                GlassySearchBar()
            }
            EventCardsSection()
            BottomNavigationBar()
        }
    }
}
