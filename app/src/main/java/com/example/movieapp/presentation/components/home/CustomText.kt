package com.example.movieapp.presentation.components.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(name: String, maxCharsPerLine: Int) {
    val lines = name.chunked(maxCharsPerLine)
    Column(
        modifier = Modifier.padding(top = 10.dp)
    ) {
        for (line in lines) {
            Text(
                text = line,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}