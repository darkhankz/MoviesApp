package com.example.moviesapp.data

data class MoviesData(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)