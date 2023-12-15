package com.example.jetrawg.data.network

import com.example.jetrawg.data.network.api.ApiService
import com.example.jetrawg.data.network.api.Resource
import com.example.jetrawg.data.network.model.GameDetails
import com.example.jetrawg.data.network.model.GamesResponse
import com.example.jetrawg.data.network.model.SearchResponse
import com.example.jetrawg.utils.toGameDetails
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

    suspend fun getGameDetails(id: Int): Resource<GameDetails> {
        try {
            val response = apiService.getGameDetails(id).toGameDetails()
            return Resource.Success(response)
        } catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    suspend fun doSearchGame(query: String) : Resource<SearchResponse>{
        try {
            val response = apiService.doSearchGame(query)
            return Resource.Success(response)
        }catch (e: Exception){
            return Resource.Error(e.toString())
        }
    }
}