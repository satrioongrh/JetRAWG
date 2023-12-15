package com.example.jetrawg.presentation.Screen.Detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetrawg.data.local.LocalDataRepository
import com.example.jetrawg.data.network.RemoteDataRepository
import com.example.jetrawg.data.network.api.Resource
import com.example.jetrawg.data.network.model.GameDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val remoteDataRepository: RemoteDataRepository,
    private val localDataRepository: LocalDataRepository
) :
    ViewModel() {

    private val _detailGames = mutableStateOf<DetailState>(DetailState())
    val detailGames: State<DetailState> = _detailGames

    fun getGameDetail(id: Int) {
        _detailGames.value = DetailState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val detailResult = remoteDataRepository.getGameDetails(id)
            when (detailResult) {
                is Resource.Success -> {
                    _detailGames.value = DetailState(data = detailResult.data)
                    Log.d("nilai", "getGameDetail: ${_detailGames.value.data}")
                    isFavorite(id)
                }

                is Resource.Error -> {
                    _detailGames.value = DetailState(error = detailResult.error)
                }

                else -> {}
            }
        }
    }



    fun addToFavorites(gameDetail: GameDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            val isCurrentlyFavorite = _detailGames.value.isFavorite
            if (isCurrentlyFavorite) {
                localDataRepository.deleteGameDetail(gameDetail.id)
            } else {
                val filteredScreenshots = gameDetail.screenshots?.filterNotNull() ?: emptyList()
                val gameDetailWithoutNulls = gameDetail.copy(screenshots = filteredScreenshots)

                localDataRepository.insertGameDetail(gameDetailWithoutNulls)
            }
            _detailGames.value = _detailGames.value.copy(isFavorite = !isCurrentlyFavorite)
        }
    }



    fun isFavorite(gameId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            localDataRepository.isFavorite(id = gameId).collect { result ->
                _detailGames.value = _detailGames.value.copy(isFavorite = result)
            }
        }
    }
}