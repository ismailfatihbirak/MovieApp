package com.example.movieapp.domain.use_case.get_detail_movie

import com.example.movieapp.domain.model.detail.Detail
import com.example.movieapp.domain.model.discover_popular.Discover
import com.example.movieapp.domain.repository.MovieRepo
import com.example.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailMovieUseCase @Inject constructor(private val repository: MovieRepo) {
    fun executeGetDetailMovie(movieId: String): Flow<Resource<Detail>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getDetailMovie(movieId = movieId)
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}


