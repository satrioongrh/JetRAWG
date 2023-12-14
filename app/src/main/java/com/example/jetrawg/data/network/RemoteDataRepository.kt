package com.example.jetrawg.data.network

import com.example.jetrawg.data.network.api.ApiService
import com.example.jetrawg.data.network.api.Resource
import com.example.jetrawg.data.network.model.GameDetailResponse
import com.example.jetrawg.data.network.model.GamesResponse
import javax.inject.Inject

class RemoteDataRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getGames(): Resource<GamesResponse> {
        try {
            val gamesResponse = apiService.getGames()
            return Resource.Success(gamesResponse)
        } catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    suspend fun getGameDetails(id: Int): Resource<GameDetailResponse> {
        try {
            val response = apiService.getGameDetails(id)
            return Resource.Success(response)
        } catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }
}