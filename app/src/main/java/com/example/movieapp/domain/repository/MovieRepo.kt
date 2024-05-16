package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.detail.Detail
import com.example.movieapp.domain.model.discover_popular.Discover


interface MovieRepo {
    suspend fun getPopularMovie(): Discover
    suspend fun getTopRatedMovie(): Discover
    suspend fun getDetailMovie(movieId: String): Detail
}