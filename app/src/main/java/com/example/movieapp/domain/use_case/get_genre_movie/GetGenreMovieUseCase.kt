package com.example.movieapp.domain.use_case.get_genre_movie

import com.example.movieapp.data.repository.MovieRepoImpl
import com.example.movieapp.domain.model.discover_popular.Discover
import com.example.movieapp.domain.repository.MovieRepo
import com.example.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetGenreMovieUseCase @Inject constructor(private val repo: MovieRepo) {

    fun executeGetGenreMovie(genresId: String): Flow<Resource<Discover>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repo.getGenreMovie(genresId = genresId)
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}