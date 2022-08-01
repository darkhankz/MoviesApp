package com.example.moviesapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.view.adapters.CustomAdapter
import com.example.moviesapp.viewModel.MoviesViewModel

class MainActivity : AppCompatActivity(), CustomAdapter.ItemClickListener {
    private val mViewModel : MoviesViewModel = MoviesViewModel()
    private lateinit var mMoviesRecyclerView: RecyclerView
    private lateinit var mMoviesAdapter : CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initObservers()
        mViewModel.getMovies()
    }

    private fun initObservers() {
        mViewModel.apply {
            movies.observe(this@MainActivity){
                mMoviesAdapter = CustomAdapter(it, this@MainActivity)
                mMoviesRecyclerView.adapter = mMoviesAdapter
            }
        }
    }

    private fun initViews() {
        mMoviesRecyclerView = findViewById(R.id.recyclerview)
        mMoviesRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this@MainActivity, "click $position", Toast.LENGTH_LONG).show()

        val intent = Intent(this@MainActivity, MoviesDetailsActivity::class.java)
        intent.putExtra("id", position)
        startActivity(intent)
    }
}