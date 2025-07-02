package com.krushna.weather.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationBar() {
    Row(
        Modifier.fillMaxWidth().padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomNavItem(Icons.Default.Home, "Home")
        BottomNavItem(Icons.Default.Cloud, "Weather")
        BottomNavItem(Icons.Default.Map, "Map")
        BottomNavItem(Icons.Default.Flight, "Travel")
        BottomNavItem(Icons.Default.Menu, "Hub")
    }
}

@Composable
fun BottomNavItem(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = label, tint = Color.White)
        Text(label, fontSize = 10.sp, color = Color.White, textAlign = TextAlign.Center)
    }
}
