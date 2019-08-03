package com.example.karaborg.yifymovies.service

import com.example.karaborg.yifymovies.data.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService{
    @GET("list_movies.json/")
    fun getCurrentMovieData(
        @Query("limit") limit: Int): Call<MovieResponse>
}