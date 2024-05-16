package com.example.movieapp.domain.model.discover_popular

data class Discover(
    val page: Int? = null,
    val results: List<Result> = listOf(),
    val total_pages: Int? = null,
    val total_results: Int? = null
)