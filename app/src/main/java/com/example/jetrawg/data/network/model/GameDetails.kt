package com.example.jetrawg.data.network.model

import androidx.room.Entity

@Entity(
    tableName = "favorite",
    primaryKeys = ["id"],
)
data class GameDetails(
    val id: Int,
    val name: String,
    val released: String?,
    val backgroundImage: String?,
    val description: String?,
    val descriptionRaw: String?,
    val rating: Double?,
    val ratingsCount: Int?,
    val ratingTop: Int?,
    val playtime: Int?,
    val ratings: List<RatingsItem?>?,
    val genres: List<GenresItem?>?,
    val developers: List<DevelopersItem?>?,
    val tags: List<TagsItem>?,
    val metacritic: String?,
    val added: Int?,
    val parrentPlatforms: List<String?>?,
    val platforms: List<String?>?,
    val stores: List<Store?>?,
    val publisher: List<PublishersItem?>?,
    val website: String?,
    val screenshots: List<String?>?,
    val isFavorite: Boolean
)