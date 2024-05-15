package com.example.movieapp.domain.model.discover_popular

data class Discover(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)