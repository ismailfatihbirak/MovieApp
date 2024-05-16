package com.example.movieapp.presentation.components.home

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieapp.presentation.home.HomeState

@Composable
fun HomeLazyRow(modifier: Modifier, state: HomeState, navController: NavController) {
    LazyRow {
        items(count = state.movie.results.size,
            itemContent = {
                val movie = state.movie.results[it]
                PopularAndDiscoverMovieCard(
                    modifier = modifier,
                    image = movie.poster_path!!,
                    name = movie.title!!,
                    movie.id!!,
                    navController
                )
            })
    }
}
