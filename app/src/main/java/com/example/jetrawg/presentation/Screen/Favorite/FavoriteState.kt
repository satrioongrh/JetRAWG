package com.example.jetrawg.presentation.Screen.Favorite

import com.example.jetrawg.data.network.model.GameDetails

data class FavoritesState(
    val isLoading: Boolean = false,
    val favorites: List<GameDetails> = emptyList(),
    val error: String = "",
)