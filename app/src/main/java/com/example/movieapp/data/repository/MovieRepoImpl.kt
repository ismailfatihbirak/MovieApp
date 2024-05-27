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

    override suspend fun getGenreMovie(genresId: String): Discover {
        return api.getGenreMovie(genresId)
    }


    override suspend fun getDetailMovie(movieId: String): Detail {
        return api.getDetailMovie(movie_id = movieId)
    }


    override suspend fun getSearchMovie(query: String): Discover {
        return api.getSearchMovie(query = query)
    }
}