package com.example.movieapp.data.di

import com.example.movieapp.data.remote.MovieApi
import com.example.movieapp.data.repository.MovieRepoImpl
import com.example.movieapp.domain.repository.MovieRepo
import com.example.movieapp.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUniversityApi(): MovieApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUniversityRepo(api: MovieApi): MovieRepo {
        return MovieRepoImpl(api = api)
    }
}