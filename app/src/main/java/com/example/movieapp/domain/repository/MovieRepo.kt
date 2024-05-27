package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.detail.Detail
import com.example.movieapp.domain.model.discover_popular.Discover
import com.example.movieapp.domain.model.videos.Videos


interface MovieRepo {
    suspend fun getPopularMovie(): Discover
    suspend fun getGenreMovie(genresId: String): Discover
    suspend fun getDetailMovie(movieId: String): Detail

    suspend fun getSearchMovie(query: String): Discover
}