package com.example.jetrawg.presentation.Screen.Detail

import com.example.jetrawg.data.network.model.GameDetailResponse

data class DetailState(
    var isLoading: Boolean= false,
    var data: GameDetailResponse? = null,
    var error: String =  ""
)