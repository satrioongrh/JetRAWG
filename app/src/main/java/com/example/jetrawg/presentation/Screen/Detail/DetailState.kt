package com.example.jetrawg.presentation.Screen.Detail

import com.example.jetrawg.data.network.model.GameDetails

data class DetailState(
    var isLoading: Boolean= false,
    var data: GameDetails? = null,
    var error: String =  "",
    val isFavorite: Boolean = false
)

data class DetailStateLocal(
    var isLoading: Boolean= false,
    var data: GameDetails? = null,
    var error: String =  "",
    val isFavorite: Boolean = false
)