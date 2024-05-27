package com.example.movieapp.presentation.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.presentation.home.HomeState

@Composable
fun MostPopularLazyRow(genreState: State<HomeState>,navController: NavController) {
    LazyRow {
        items(genreState.value.movie.results) {
            Card(
                modifier = Modifier
                    .size(170.dp, 274.dp)
                    .padding(5.dp)
                    .clickable {
                        navController.navigate("detail/${it.id}")
                    }
            ) {
                Box {
                    Column {
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/original${it.poster_path}",
                            contentDescription = ""
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(id = R.color.search))
                        ) {
                            Text(
                                text = (if (it.title!!.length > 19) {
                                    it.title.take(19) + ".."
                                } else {
                                    it.title
                                }),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                            )
                        }
                    }
                }
            }
        }
    }
}