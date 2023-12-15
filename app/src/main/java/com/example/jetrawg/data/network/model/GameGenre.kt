package com.example.jetrawg.data.network.model

import com.google.gson.annotations.SerializedName

data class GameGenre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)