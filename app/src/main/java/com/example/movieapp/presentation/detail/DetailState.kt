package com.example.movieapp.presentation.detail

import com.example.movieapp.domain.model.detail.Detail
import com.example.movieapp.domain.model.videos.Videos

data class DetailState(
    val isLoading: Boolean = false,
    val movie: Detail = Detail(),
    val video: Videos = Videos(),
    val error: String = "",
)
