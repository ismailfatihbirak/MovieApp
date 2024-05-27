package com.example.movieapp.presentation.home

import com.example.movieapp.domain.model.discover_popular.Discover

class HomeState (
    val isLoading: Boolean = false,
    val movie: Discover = Discover(),
    val error: String = "",
)