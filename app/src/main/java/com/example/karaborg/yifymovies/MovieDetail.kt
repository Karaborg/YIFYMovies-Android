package com.example.karaborg.yifymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.karaborg.yifymovies.data.MovieResponse
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity() {

    lateinit var movieResponse: MovieResponse
    private var pos: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieResponse = intent.extras.getSerializable("movieResponse") as MovieResponse
        pos = intent.extras.getInt("pos")

        txtMovieTitle.text = movieResponse.data!!.movies!![pos]!!.title
        txtDescription.text = movieResponse.data!!.movies!![pos]!!.descriptionFull
    }

    fun Back(view: View){

        onBackPressed()

    }

}
