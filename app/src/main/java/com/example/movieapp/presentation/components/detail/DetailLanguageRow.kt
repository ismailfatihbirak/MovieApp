package com.example.movieapp.presentation.components.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.movieapp.R

@Composable
fun DetailLanguageRow(text: String, painter: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = text)
        Icon(
            painter = painterResource(id = painter),
            contentDescription = "", tint = colorResource(id = R.color.textblue)
        )
    }
}