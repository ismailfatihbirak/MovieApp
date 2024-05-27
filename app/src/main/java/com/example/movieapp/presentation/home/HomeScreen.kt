package com.example.movieapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.presentation.components.home.CategoryButtons
import com.example.movieapp.presentation.components.home.MostPopularLazyRow
import com.example.movieapp.presentation.components.home.MoviePager
import com.example.movieapp.presentation.splash.TextTitle
import com.example.movieapp.util.Genre

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navController: NavController) {
    LaunchedEffect(true) {
        viewModel.loadPopularMovie()
        viewModel.loadGetGenreMovie("28")
    }
    val popularState = viewModel.popularState
    val genreState = viewModel.genreState
    val searchState = viewModel.searchState

    val genreMap = Genre.entries.associateBy { it.displayName }
    val categories = listOf(
        "Action",
        "Adventure",
        "Animation",
        "Comedy",
        "Crime",
        "History",
        "Horror",
        "Science Fiction",
        "War"
    )
    val selectedButtonIndex = remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("") }
    val pagerState = rememberPagerState(pageCount = { popularState.value.movie.results.size })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        TextTitle()

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colorResource(id = R.color.search),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                disabledTextColor = Color.White,
                focusedSupportingTextColor = Color.White,
                unfocusedSupportingTextColor = Color.White,
            ),
            label = { Text(text = "Search", color = Color.White) },
            maxLines = 1,
            shape = RoundedCornerShape(50),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null, tint = Color.White
                )
            },
            onValueChange = { newText ->
                text = newText
                if (newText.isNotBlank()) {
                    text = newText
                }
            })



        Spacer(modifier = Modifier.height(10.dp))

        if (text.isBlank()) {
            if (popularState.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                MoviePager(
                    pagerState = pagerState,
                    movies = popularState.value.movie.results,
                    navController = navController
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 40.dp)
            ) {
                Text(
                    text = "Categories",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }

            CategoryButtons(categories, viewModel, genreMap, selectedButtonIndex)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 30.dp)
            ) {
                Text(
                    text = "Most Popular",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }

            if (genreState.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                MostPopularLazyRow(genreState, navController)
            }
        } else {
            LaunchedEffect(text) {
                viewModel.loadGetSearchMovie(text)
            }
            if (viewModel.searchState.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                LazyColumn {
                    items(searchState.value.movie.results) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.clickable {
                                navController.navigate("detail/${it.id}")
                            }
                        ) {
                            AsyncImage(
                                model = "https://image.tmdb.org/t/p/original${it.poster_path}",
                                contentDescription = null,
                                modifier = Modifier
                                    .size(169.dp, 222.dp)
                                    .padding(bottom = 10.dp)
                            )
                            Column(
                                verticalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = (if (it.title!!.length > 17) {
                                        it.title.take(17) + ".."
                                    } else {
                                        it.title
                                    }),
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.height(25.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_calendar),
                                        contentDescription = "",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Text(
                                        text = it.release_date.toString().take(4),
                                        color = Color.Gray,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(start = 5.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(25.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = it.vote_average.toString().take(3),
                                        color = colorResource(id = R.color.orange),
                                        modifier = Modifier.padding(start = 5.dp),
                                        fontSize = 18.sp
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.star),
                                        contentDescription = "",
                                        tint = colorResource(id = R.color.orange),
                                        modifier = Modifier
                                            .padding(start = 5.dp, end = 5.dp)
                                            .size(18.dp)
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}




















