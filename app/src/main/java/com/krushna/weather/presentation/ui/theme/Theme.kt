// Theme.kt
package com.krushna.weather.presentation.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Purple500,
    onPrimary = Color.White,
    secondary = Teal200,
    onSecondary = Color.Black,
)

@Composable
fun WeatherAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
