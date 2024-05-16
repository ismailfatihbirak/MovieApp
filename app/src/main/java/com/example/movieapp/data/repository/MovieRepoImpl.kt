package com.example.movieapp.data.repository

import com.example.movieapp.data.remote.MovieApi
import com.example.movieapp.domain.model.detail.Detail
import com.example.movieapp.domain.model.discover_popular.Discover
import com.example.movieapp.domain.repository.MovieRepo
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private val api: MovieApi) : MovieRepo {
    override suspend fun getPopularMovie(): Discover {
        return api.getPopularMovie()
    }

    override suspend fun getTopRatedMovie(): Discover {
        return api.getTopRatedMovie()
    }

    override suspend fun getDetailMovie(movieId: String): Detail {
        return api.getDetailMovie(movie_id = movieId)
    }
}