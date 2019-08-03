package com.example.karaborg.yifymovies.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResponse(

	@field:SerializedName("status_message")
	val statusMessage: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("@meta")
	val meta: Meta? = null,

	@field:SerializedName("status")
	val status: String? = null
) :Serializable