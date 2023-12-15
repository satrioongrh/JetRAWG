package com.example.jetrawg.data.local

import com.example.jetrawg.data.local.db.GamesDao
import com.example.jetrawg.data.network.model.GameDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataRepository @Inject constructor(private val gamesDao: GamesDao) {

    suspend fun insertGameDetail(gameDetail: GameDetails) {
        gamesDao.insertFavorite(gameDetail)
    }

    suspend fun getGameDetail(gameId: Int): GameDetails? {
        return gamesDao.getGameDetail(gameId)
    }

    fun getFavoriteGames(): Flow<List<GameDetails>> {
        return gamesDao.getAllFavorites()
    }

    suspend fun deleteGameDetail(gameId: Int) {
        gamesDao.deleteFavorite(gameId)
    }

    fun isFavorite(id: Int): Flow<Boolean> = gamesDao.isFavorite(id)

}
