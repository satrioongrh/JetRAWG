package com.example.jetrawg.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetrawg.data.network.model.GameDetails
import com.example.jetrawg.utils.Converter

@TypeConverters(Converter::class)
@Database(entities = [GameDetails::class], version = 1, exportSchema = false)
abstract class GamesDatabase : RoomDatabase() {

    abstract fun gamesDao(): GamesDao

}