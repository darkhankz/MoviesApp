package com.example.moviesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.data.MoviesData
import com.example.moviesapp.data.MoviesDetailsData
import com.example.moviesapp.data.Result
import com.example.moviesapp.model.repository.MoviesDbRepository
import com.example.moviesapp.model.repository.MoviesDbRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel {
    private val mMoviesRepository : MoviesDbRepository = MoviesDbRepositoryImpl()
    private val _movies = MutableLiveData<List<Result>>()
    val movies : LiveData<List<Result>> = _movies

    private val _moviesDetails = MutableLiveData<MoviesDetailsData>()
    val moviesDetails : LiveData<MoviesDetailsData> = _moviesDetails
    fun getMovies(){
        val response = mMoviesRepository.getMovies()
        response.enqueue(object : Callback<MoviesData>{
            override fun onResponse(call: Call<MoviesData>, response: Response<MoviesData>) {
                _movies.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<MoviesData>, t: Throwable) {
            }

        })
    }

    fun getMoviesDetails(id : Int){
        val response = mMoviesRepository.getMoviesDetails(id)
        response.enqueue(object : Callback<MoviesDetailsData>{
            override fun onResponse(
                call: Call<MoviesDetailsData>, response: Response<MoviesDetailsData>) {
                _moviesDetails.postValue(response.body())

            }

            override fun onFailure(call: Call<MoviesDetailsData>, t: Throwable) {
            }

        })

    }
}