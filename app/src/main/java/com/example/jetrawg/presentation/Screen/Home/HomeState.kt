package com.example.jetrawg.presentation.Screen.Home

import com.example.jetrawg.data.network.model.GamesResponse
import com.example.jetrawg.data.network.model.SearchResponse

data class HomeState(
    var isLoading: Boolean= false,
    var data: GamesResponse? = null,
    var error: String =  ""
)

data class SearchState(
    var isLoading: Boolean= false,
    var data: SearchResponse? = null,
    var error: String =  ""
)