package com.example.moviesapp.model.repository

import com.example.moviesapp.data.MoviesData
import com.example.moviesapp.data.MoviesDetailsData
import retrofit2.Call

interface MoviesDbRepository {
    fun getMovies() : Call<MoviesData>

    fun getMoviesDetails(id : Int) : Call<MoviesDetailsData>
}