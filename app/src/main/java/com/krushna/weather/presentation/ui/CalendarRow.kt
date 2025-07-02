package com.krushna.weather.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text



@Composable
fun CalendarRow() {
    val days = listOf("18", "19", "20", "21", "22", "23", "24")
    val selectedDay = remember { mutableStateOf("19") }

    LazyRow {
        items(days) { day ->
            Box(
                Modifier
                    .padding(4.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        if (day == selectedDay.value) Color.White.copy(alpha = 0.9f) else Color.White.copy(alpha = 0.3f)
                    )
                    .clickable { selectedDay.value = day },
                contentAlignment = Alignment.Center
            ) {
                Text(day, color = if (day == selectedDay.value) Color.Black else Color.White)
            }
        }
    }
}
