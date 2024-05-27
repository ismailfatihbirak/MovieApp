package com.example.movieapp.presentation.detail

import com.example.movieapp.domain.model.detail.Detail

data class DetailState(
    val isLoading: Boolean = false,
    val movie: Detail = Detail(),
    val error: String = "",
)
