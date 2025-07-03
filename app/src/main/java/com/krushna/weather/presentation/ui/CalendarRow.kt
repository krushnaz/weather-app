package com.krushna.weather.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarRow() {
    val days = listOf("18", "19", "20", "21", "22", "23", "24")
    var selectedDay by remember { mutableStateOf("19") }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(days) { day ->
            Surface(
                shape = CircleShape,
                color = if (day == selectedDay) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1f),
                tonalElevation = if (day == selectedDay) 4.dp else 0.dp,
                shadowElevation = if (day == selectedDay) 4.dp else 0.dp,
                modifier = Modifier
                    .size(48.dp)
                    .clickable { selectedDay = day }
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = day,
                        fontSize = 16.sp,
                        color = if (day == selectedDay) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary,
                        fontWeight = if (day == selectedDay) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }
    }
}
