package com.example.movieapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.movieapp.R


@Composable
fun DetailScreen(movieId: String, viewModel: DetailViewModel = hiltViewModel()) {
    LaunchedEffect(true) {
        viewModel.loadGetDetailMovie(movieId)
    }
    val detailState = viewModel.detailState

    if (detailState.value.isLoading) {
        Column {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.background))
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original${detailState.value.movie.poster_path}",
                contentDescription = null,
                modifier = Modifier
                    .alpha(0.3f)
            )
            Column(
                modifier = Modifier
                    .padding(top = 80.dp)
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = detailState.value.movie.title.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                AsyncImage(
                    modifier = Modifier
                        .size(240.dp, 337.dp)
                        .padding(top = 30.dp, bottom = 30.dp),
                    model = "https://image.tmdb.org/t/p/original${detailState.value.movie.poster_path}",
                    contentDescription = ""
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_calendar),
                        contentDescription = "", tint = Color.Gray
                    )
                    Text(
                        text = detailState.value.movie.release_date.toString().take(4),
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_line),
                        contentDescription = "",
                        tint = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_clock),
                        contentDescription = "", tint = Color.Gray
                    )
                    Text(
                        text = detailState.value.movie.runtime.toString() + " Minutes",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_line),
                        contentDescription = "",
                        tint = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_film),
                        contentDescription = "", tint = Color.Gray
                    )
                    detailState.value.movie.genres?.get(0)?.name?.let {
                        Text(
                            text = it,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
                Card(
                    modifier = Modifier.padding(bottom = 30.dp),
                    colors = CardColors(
                        containerColor = colorResource(id = R.color.search),
                        contentColor = Color.White,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.White
                    )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = detailState.value.movie.vote_average.toString().take(3),
                            color = colorResource(id = R.color.orange),
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "",
                            tint = colorResource(id = R.color.orange),
                            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                        )
                    }
                }

                Column(modifier = Modifier.padding(start = 10.dp, top = 75.dp)) {
                    Text(
                        text = "Story Line",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Text(
                        text = detailState.value.movie.overview.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier.padding(top = 7.dp)
                    )

                }
            }
        }
    }
}


