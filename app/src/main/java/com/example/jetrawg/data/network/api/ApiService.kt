package com.example.jetrawg.data.network.api

import com.example.jetrawg.data.network.model.GameDetailResponse
import com.example.jetrawg.data.network.model.GamesResponse
import com.example.jetrawg.data.network.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/games?")
    suspend fun getGames(
    ) : GamesResponse

    @GET("api/games/{id}")
    suspend fun getGameDetails(
        @Path("id") id: Int,
    ): GameDetailResponse

    @GET("api/games?")
    suspend fun doSearchGame(
        @Query("search") query: String,
    ): SearchResponse
}