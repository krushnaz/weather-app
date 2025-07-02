package com.krushna.weather

import android.os.Bundle
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.krushna.weather.presentation.viewmodel.WeatherViewModel
import com.krushna.weather.presentation.ui.theme.WeatherAppTheme
import com.krushna.weather.presentation.ui.screens.WeatherScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make the app draw behind the system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // Make status bar transparent
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        // Set light or dark status bar icons (false = light icons, true = dark icons)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        setContent {
            val viewModel: WeatherViewModel = hiltViewModel()
            WeatherAppTheme {
                WeatherScreen(viewModel = viewModel)
            }
        }
    }
}
