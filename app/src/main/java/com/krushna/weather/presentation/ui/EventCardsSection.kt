package com.krushna.weather.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ForecastItem(
    val time: String,
    val temperature: String,
    val type: WeatherType
)

enum class WeatherType { SUNNY, CLOUDY, STORMY }

@Composable
fun WeatherForecastRow() {
    val forecastList = listOf(
        ForecastItem("9 AM", "25°", WeatherType.SUNNY),
        ForecastItem("12 PM", "28°", WeatherType.SUNNY),
        ForecastItem("3 PM", "30°", WeatherType.CLOUDY),
        ForecastItem("6 PM", "26°", WeatherType.STORMY),
        ForecastItem("9 PM", "23°", WeatherType.CLOUDY)
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(forecastList) { item ->
            ForecastCard(item)
        }
    }
}

@Composable
fun ForecastCard(item: ForecastItem) {
    // Choose color based on weather type
    val cardColor = when (item.type) {
        WeatherType.SUNNY -> Color(0xFFFFF8E1) // light yellow
        WeatherType.CLOUDY -> Color(0xFFE1F5FE) // very light blue
        WeatherType.STORMY -> Color(0xFFFFEBEE) // very light red
    }

    Card(
        shape = RoundedCornerShape(16.dp), // more rounded, modern look
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .size(100.dp) // square card
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                item.time,
                fontSize = 12.sp,
                color = Color.Black
            )
            Icon(
                imageVector = when (item.type) {
                    WeatherType.SUNNY -> Icons.Default.WbSunny
                    WeatherType.CLOUDY -> Icons.Default.Cloud
                    WeatherType.STORMY -> Icons.Default.Bolt
                },
                contentDescription = null,
                tint = Color.Black
            )
            Text(
                item.temperature,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}