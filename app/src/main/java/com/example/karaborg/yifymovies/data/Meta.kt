package com.example.karaborg.yifymovies.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meta(

	@field:SerializedName("server_time")
	val serverTime: Int? = null,

	@field:SerializedName("server_timezone")
	val serverTimezone: String? = null,

	@field:SerializedName("api_version")
	val apiVersion: Int? = null,

	@field:SerializedName("execution_time")
	val executionTime: String? = null
): Serializable