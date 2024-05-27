package com.example.movieapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.use_case.get_genre_movie.GetGenreMovieUseCase
import com.example.movieapp.domain.use_case.get_popular_movie.GetPopularMovieUseCase
import com.example.movieapp.domain.use_case.get_search_movie.GetSearchMovieUseCase
import com.example.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase,
    private val getGenreMovieUseCase: GetGenreMovieUseCase,
    private val getSearchMovieUseCase: GetSearchMovieUseCase
) : ViewModel() {

    private val _popularState = mutableStateOf<HomeState>(HomeState())
    val popularState: State<HomeState> = _popularState

    private val _genreState = mutableStateOf<HomeState>(HomeState())
    val genreState: State<HomeState> = _genreState

    private val _searchState = mutableStateOf<HomeState>(HomeState())
    val searchState: State<HomeState> = _searchState


    private fun getPopularMovie() {
        getPopularMovieUseCase.executeGetPopularMovie().onEach {
            when (it) {
                is Resource.Success -> {
                    _popularState.value = it.data?.let { it1 -> HomeState(movie = it1) }!!
                }

                is Resource.Loading -> {
                    _popularState.value = HomeState(isLoading = true)
                }

                is Resource.Error -> {
                    _popularState.value = HomeState(error = it.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getGenreMovie(genresId: String) {
        getGenreMovieUseCase.executeGetGenreMovie(genresId = genresId).onEach {
            when (it) {
                is Resource.Success -> {
                    _genreState.value = it.data?.let { it1 -> HomeState(movie = it1) }!!
                }

                is Resource.Loading -> {
                    _genreState.value = HomeState(isLoading = true)
                }

                is Resource.Error -> {
                    _genreState.value = HomeState(error = it.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSearchMovie(query: String) {
        getSearchMovieUseCase.executeGetSearchMovie(query).onEach {
            when (it) {
                is Resource.Success -> {
                    _searchState.value = it.data?.let { it1 -> HomeState(movie = it1) }!!
                }

                is Resource.Loading -> {
                    _searchState.value = HomeState(isLoading = true)
                }

                is Resource.Error -> {
                    _searchState.value = HomeState(error = it.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }


    fun loadPopularMovie() {
        getPopularMovie()
    }

    fun loadGetGenreMovie(genresId: String) {
        getGenreMovie(genresId = genresId)
    }

    fun loadGetSearchMovie(query: String) {
        getSearchMovie(query)
    }


}