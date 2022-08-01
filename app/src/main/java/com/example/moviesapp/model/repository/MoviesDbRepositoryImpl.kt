package com.example.moviesapp.model.repository

import com.example.moviesapp.data.MoviesData
import com.example.moviesapp.data.MoviesDetailsData
import com.example.moviesapp.model.apis.ApiInterface
import retrofit2.Call

class MoviesDbRepositoryImpl : MoviesDbRepository {
    private val apiInterface = ApiInterface.create()
    override fun getMovies(): Call<MoviesData> {
        return apiInterface.getMovies("6e76ecffda0a59dc4f19a343c6e7648a")

    }

    override fun getMoviesDetails(id: Int): Call<MoviesDetailsData> {
        return apiInterface.getMoviesDetails(id, "6e76ecffda0a59dc4f19a343c6e7648a")
    }

}