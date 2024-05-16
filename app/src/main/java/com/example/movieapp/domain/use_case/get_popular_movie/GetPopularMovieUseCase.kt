package com.example.movieapp.domain.use_case.get_popular_movie

import com.example.movieapp.domain.model.discover_popular.Discover
import com.example.movieapp.domain.repository.MovieRepo
import com.example.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(private val repository: MovieRepo) {
    fun executeGetPopularMovie(): Flow<Resource<Discover>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getPopularMovie()
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}