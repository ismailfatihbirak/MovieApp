package com.example.movieapp.presentation.home

import com.example.movieapp.domain.model.detail.Detail
import com.example.movieapp.domain.model.discover_popular.Discover
import com.example.movieapp.domain.model.videos.Videos

class HomeState (
    val isLoading: Boolean = false,
    val movie: Discover = Discover(),
    val error: String = "",
)