package com.example.movieapp.data.remote

import com.example.movieapp.domain.model.detail.Detail
import com.example.movieapp.domain.model.discover_popular.Discover
import com.example.movieapp.util.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    //https://api.themoviedb.org/3/movie/popular?api_key=3c7595560643527986a52ffda061167b
    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = API_KEY
    ): Discover

    //https://api.themoviedb.org/3/discover/movie?with_genres=28&api_key=3c7595560643527986a52ffda061167b
    @GET("discover/movie")
    suspend fun getGenreMovie(
        @Query("with_genres") genres_id: String,
        @Query("api_key") apiKey: String = API_KEY
    ): Discover

    //https://api.themoviedb.org/3/movie/940721?api_key=3c7595560643527986a52ffda061167b
    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movie_id: String,
        @Query("api_key") apiKey: String = API_KEY
    ): Detail


    //https://api.themoviedb.org/3/search/movie?api_key=3c7595560643527986a52ffda061167b&query=barbie

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("query") query: String,
    ): Discover
}