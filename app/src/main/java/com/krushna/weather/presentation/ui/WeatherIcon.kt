package com.krushna.weather.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.*
import androidx.compose.ui.Modifier

@Composable
fun WeatherIcon(weather: String, modifier: Modifier = Modifier) {
    val assetName = when {
        weather.contains("rain", true) -> "rainy.json"
        weather.contains("cloud", true) -> "cloudy.json"
        weather.contains("clear", true) -> "sunny.json"
        else -> "partly_cloudy.json"
    }

    val composition = rememberLottieComposition(LottieCompositionSpec.Asset(assetName))
    val progress by animateLottieCompositionAsState(composition.value)

    LottieAnimation(
        composition = composition.value,
        progress = progress,
        modifier = modifier
    )
}
