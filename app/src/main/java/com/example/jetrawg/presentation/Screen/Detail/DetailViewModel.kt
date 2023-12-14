package com.example.jetrawg.presentation.Screen.Detail

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
class DetailViewModel @Inject constructor(private val remoteDataRepository: RemoteDataRepository) :
    ViewModel() {

    private val _detailGames = mutableStateOf<DetailState>(DetailState())
    val detailGames: State<DetailState> = _detailGames

    fun getGameDetail(id: Int) {
        _detailGames.value = DetailState(isLoading = true)
        viewModelScope.launch (Dispatchers.IO) {
            val detailResult = remoteDataRepository.getGameDetails(id)
            when (detailResult){
                is Resource.Success -> {
                    _detailGames.value = DetailState(data = detailResult.data)
                }
                is Resource.Error -> {
                    _detailGames.value = DetailState(error = detailResult.error)
                }
                else -> {}
            }
        }
    }

}