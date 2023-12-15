package com.example.jetrawg.presentation.Screen.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetrawg.data.network.RemoteDataRepository
import com.example.jetrawg.data.network.api.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteDataRepository: RemoteDataRepository
) : ViewModel() {

    private val _games = mutableStateOf<HomeState>(HomeState())
    val games: State<HomeState> = _games

    private val _search = mutableStateOf<SearchState>(SearchState())
    val search: State<SearchState> = _search

    init {
        getGames()
    }

    private fun getGames() {
        _games.value = HomeState(isLoading = true)
        viewModelScope.launch (Dispatchers.IO) {
            val gamesResult = remoteDataRepository.getGames()
            when (gamesResult){
                is Resource.Success -> {
                    _games.value = HomeState(data = gamesResult.data)
                }
                is Resource.Error -> {
                    _games.value = HomeState(error = gamesResult.error)
                }
                else -> {}
            }
        }
    }

    fun doSearchGames(query: String) {
        _search.value = SearchState(isLoading = true)
        viewModelScope.launch (Dispatchers.IO) {
            val gamesResult = remoteDataRepository.doSearchGame(query)
            when (gamesResult){
                is Resource.Success -> {
                    _search.value = SearchState(data = gamesResult.data)
                }
                is Resource.Error -> {
                    _search.value = SearchState(error = gamesResult.error)
                }
                else -> {}
            }
        }
    }
}