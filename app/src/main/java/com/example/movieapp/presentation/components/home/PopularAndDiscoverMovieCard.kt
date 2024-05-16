package com.example.movieapp.presentation.components.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.presentation.home.CustomText

@Composable
fun PopularAndDiscoverMovieCard(
    modifier: Modifier,
    image: String,
    name: String,
    id: Int,
    navController: NavController
) {
    Card(
        onClick = {
            navController.navigate("detail/${id}")
        },
        modifier = Modifier.padding(start = 24.dp, end = 15.dp, top = 15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${image}",
                contentDescription = "",
                modifier = modifier
            )
            CustomText(name = name, maxCharsPerLine = 17)
        }
    }
}