package com.example.movieapp.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.presentation.components.detail.DetailLanguageRow
import com.example.movieapp.presentation.components.home.ProgressInducator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(movieId: String, viewModel: DetailViewModel = hiltViewModel()) {
    LaunchedEffect(true) {
        viewModel.loadGetDetailMovie(movieId)
    }
    val detailState = viewModel.detailState
    Scaffold(
        topBar = {
            TopAppBar(title =
            {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "DETAİL",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.textblue))
                }
            })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            if (detailState.value.isLoading) {
                ProgressInducator()
            } else {
                val movie = detailState.value.movie
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
                        contentDescription = "",
                        modifier = Modifier.size(350.dp, 400.dp)
                    )
                    Text(
                        text = movie.title.toString(),
                        fontSize = 24.sp,
                        color = colorResource(id = R.color.textblue)
                    )
                    Text(text = "(${movie.release_date})", fontSize = 22.sp)
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        DetailLanguageRow(
                            movie.original_language.toString() + " ",
                            R.drawable.icon_language
                        )
                        DetailLanguageRow("${movie.runtime} minütes ", R.drawable.icon_clock)
                        DetailLanguageRow(
                            movie.vote_average.toString().take(3) + " ",
                            R.drawable.icon_star
                        )
                    }
                    Text(text = movie.overview.toString(),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                }


            }
        }
    }
}

