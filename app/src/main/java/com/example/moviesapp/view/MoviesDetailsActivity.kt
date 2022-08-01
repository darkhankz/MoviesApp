package com.example.moviesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.moviesapp.R
import com.example.moviesapp.data.MoviesDetailsData
import com.example.moviesapp.viewModel.MoviesViewModel
import com.squareup.picasso.Picasso

class MoviesDetailsActivity : AppCompatActivity() {
    private val mViewModel : MoviesViewModel = MoviesViewModel()

    private lateinit var title : TextView
    private lateinit var score : TextView
    private lateinit var banner : ImageView
    private lateinit var overview : TextView
    private lateinit var releaseDate : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details)
        val id = intent.getIntExtra("id", 0)
        mViewModel.getMoviesDetails(id)
        Log.d("testing", "id $id")
        initView()
        initObservers()
    }

    private fun initObservers() {
        mViewModel.apply {
            moviesDetails.observe(this@MoviesDetailsActivity){
                setMovieInformation(it)
            }
        }
    }

    private fun initView() {
        title = findViewById(R.id.movies_details_title)
        overview = findViewById(R.id.movies_details_body_overview)
        score = findViewById(R.id.movies_details_score)
        releaseDate = findViewById(R.id.movies_details_date)
        banner = findViewById(R.id.movies_details_image_banner)
    }

    private fun setMovieInformation(movieDetails: MoviesDetailsData){
        title.text = movieDetails.title
        overview.text = movieDetails.overview
        releaseDate.text = movieDetails.release_date
        score.text = movieDetails.vote_average.toString()
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movieDetails.poster_path).into(banner)

    }



    }