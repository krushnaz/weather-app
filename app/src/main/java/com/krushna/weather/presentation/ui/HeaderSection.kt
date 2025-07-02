package com.krushna.weather.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderSection(city: String, temperature: Int, weatherState: String) {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("$temperature°", fontSize = 48.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(city, color = Color.White, fontSize = 20.sp)
            }
            Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
        }

        Spacer(Modifier.height(8.dp))

        Text(weatherState, color = Color.White, fontSize = 16.sp)
        Text(
            "Real feel: $temperature°  |  Wind: 6 mph  |  UV: 7",
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 12.sp
        )

        Spacer(Modifier.height(16.dp))

        CalendarRow()
    }
}
