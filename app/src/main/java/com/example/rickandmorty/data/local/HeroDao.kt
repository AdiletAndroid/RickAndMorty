package com.example.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroDao {

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<HeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(heroEntity: HeroEntity)

}