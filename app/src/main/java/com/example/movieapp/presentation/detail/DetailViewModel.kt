package com.example.movieapp.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.use_case.get_detail_movie.GetDetailMovieUseCase
import com.example.movieapp.presentation.home.HomeState
import com.example.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailMovieUseCase: GetDetailMovieUseCase,
) : ViewModel() {
    private val _detailState = mutableStateOf<DetailState>(DetailState())
    val detailState: State<DetailState> = _detailState

    private fun getDetailMovie(movieId: String) {
        getDetailMovieUseCase.executeGetDetailMovie(movieId).onEach {
            when (it) {
                is Resource.Success -> {
                    _detailState.value = it.data?.let { it1 -> DetailState(movie = it1) }!!
                }

                is Resource.Loading -> {
                    _detailState.value = DetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _detailState.value = DetailState(error = it.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun loadGetDetailMovie(movieId: String) {
        getDetailMovie(movieId)
    }

}