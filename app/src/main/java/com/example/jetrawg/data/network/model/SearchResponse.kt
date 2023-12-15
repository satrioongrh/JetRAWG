package com.example.jetrawg.data.network.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("user_platforms")
	val userPlatforms: Boolean? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)
