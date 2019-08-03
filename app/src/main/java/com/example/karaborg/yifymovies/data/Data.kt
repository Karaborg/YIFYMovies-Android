package com.example.karaborg.yifymovies.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(

	@field:SerializedName("movies")
	val movies: List<MoviesItem?>? = null,

	@field:SerializedName("page_number")
	val pageNumber: Int? = null,

	@field:SerializedName("movie_count")
	val movieCount: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null
) :Serializable