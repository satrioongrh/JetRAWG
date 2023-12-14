package com.example.jetrawg.presentation.Screen.Home

import com.example.jetrawg.data.network.model.GamesResponse

data class HomeState(
    var isLoading: Boolean= false,
    var data: GamesResponse? = null,
    var error: String =  ""
)