package com.krushna.weather.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HeaderSection(city: String, temperature: Int, weatherState: String) {
    val currentDate = remember {
        SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(Date())
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "$temperature°",
                    fontSize = 48.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(city, color = Color.White, fontSize = 20.sp)
            }

            // ✅ Added icon on right
            Icon(
                imageVector = Icons.Default.Cloud,
                contentDescription = null,
                tint = Color(0xFF90CAF9), // nice light blue tint, looks modern on dark bg
                modifier = Modifier.size(48.dp)
            )
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
