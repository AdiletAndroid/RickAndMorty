package com.example.rickandmorty.main_page.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.main_page.db.model.HeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<HeroEntity>

    @Query("SELECT * FROM heroes")
    fun getAllHeroesFlow(): Flow<List<HeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(heroEntity: List<HeroEntity>)

}