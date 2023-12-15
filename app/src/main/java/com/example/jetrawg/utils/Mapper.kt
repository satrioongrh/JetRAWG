package com.example.jetrawg.utils

import com.example.jetrawg.data.network.model.GameDetailResponse
import com.example.jetrawg.data.network.model.GameDetails
import com.example.jetrawg.data.network.model.GameGenre
import com.example.jetrawg.data.network.model.GenresItem

fun GameDetailResponse.toGameDetails(): GameDetails = GameDetails(
    id = id!!,
    name = name!!,
    released = released?.toString(),
    backgroundImage = backgroundImage,
    description = description,
    descriptionRaw = descriptionRaw,
    rating = rating,
    ratingsCount = ratingsCount,
    ratingTop = ratingTop,
    playtime = playtime,
    ratings = ratings,
    genres = genres,
    developers = developers,
    tags = tags,
    metacritic = metacritic?.toString(),
    added = added,
    parrentPlatforms = parentPlatforms?.map { it?.platform?.name },
    platforms = platforms?.map { it?.platform?.name },
    stores = stores?.map { it?.store },
    publisher = publishers,
    website = website,
    screenshots = null,
    isFavorite = false
)

fun GenresItem.toGameGenre(): GameGenre{
    return GameGenre(
        id = id ?: 0,
        name = name ?: "",
        slug = slug ?: "",
    )
}