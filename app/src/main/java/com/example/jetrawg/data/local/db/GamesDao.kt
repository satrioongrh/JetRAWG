package com.example.jetrawg.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jetrawg.data.network.model.GameDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(gameDetails: GameDetails)

    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): Flow<List<GameDetails>>

    @Query("DELETE FROM favorite WHERE id = :id")
    fun deleteFavorite(id: Int)

    @Query("SELECT * FROM favorite WHERE id = :gameId")
    fun getGameDetail(gameId: Int): GameDetails?

    @Query("SELECT EXISTS(SELECT * FROM favorite WHERE id = :id)")
    fun isFavorite(id: Int): Flow<Boolean>

}