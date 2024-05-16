package com.example.movieapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.use_case.get_discover_movie.GetTopRatedMovieUseCase
import com.example.movieapp.domain.use_case.get_popular_movie.GetPopularMovieUseCase
import com.example.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase,
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase
) : ViewModel() {

    private val _popularState = mutableStateOf<HomeState>(HomeState())
    val popularState: State<HomeState> = _popularState

    private val _topRatedState = mutableStateOf<HomeState>(HomeState())
    val topRatedState: State<HomeState> = _topRatedState

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

    private fun getTopRatedMovie() {
        getTopRatedMovieUseCase.executeGetTopRatedMovie().onEach {
            when (it) {
                is Resource.Success -> {
                    _topRatedState.value = it.data?.let { it1 -> HomeState(movie = it1) }!!
                }

                is Resource.Loading -> {
                    _topRatedState.value = HomeState(isLoading = true)
                }

                is Resource.Error -> {
                    _topRatedState.value = HomeState(error = it.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun loadToapRatedMovie() {
        getTopRatedMovie()
    }

    fun loadPopularMovie() {
        getPopularMovie()
    }

}