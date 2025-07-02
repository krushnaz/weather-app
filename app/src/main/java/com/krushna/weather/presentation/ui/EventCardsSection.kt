package com.krushna.weather.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
fun EventCardsSection() {
    Column {
        EventCard(title = "Top beautiful trails nearby", number = "16")
        Spacer(Modifier.height(8.dp))
        EventCard(title = "Personalized activity recommendations", number = "5")
    }
}

@Composable
fun EventCard(title: String, number: String) {
    Card(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .blur(8.dp), // more blur for glass effect
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.2f))
    ) {
        Row(
            Modifier.fillMaxSize().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(number, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(title, color = Color.White, fontSize = 12.sp, maxLines = 2)
            }
            Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
        }
    }
}
