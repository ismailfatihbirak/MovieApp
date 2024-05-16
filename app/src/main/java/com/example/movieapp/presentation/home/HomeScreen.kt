package com.example.movieapp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movieapp.R
import com.example.movieapp.presentation.components.home.HomeLazyRow
import com.example.movieapp.presentation.components.home.HomeText
import com.example.movieapp.presentation.components.home.ProgressInducator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navController: NavController) {
    LaunchedEffect(true) {
        viewModel.loadPopularMovie()
        viewModel.loadToapRatedMovie()
    }
    val popularState = viewModel.popularState
    val topRatedState = viewModel.topRatedState

    Scaffold(
        topBar = {
            TopAppBar(title =
            {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "MOVİEZ",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.textblue)
                    )
                }
            })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            HomeText(text = "Popular")
            if (popularState.value.isLoading) {
                ProgressInducator()
            } else {
                HomeLazyRow(
                    modifier = Modifier.size(138.dp, 207.dp),
                    popularState.value,
                    navController
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HomeText("Top Rated")
            if (topRatedState.value.isLoading) {
                ProgressInducator()
            } else {
                HomeLazyRow(
                    modifier = Modifier.size(171.dp, 257.dp),
                    topRatedState.value,
                    navController
                )
            }
        }
    }
}











