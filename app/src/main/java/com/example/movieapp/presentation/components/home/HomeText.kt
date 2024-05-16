package com.example.movieapp.presentation.components.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 32.dp)
    )
}