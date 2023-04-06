package com.example.rickandmorty.main_page.db.repository

import com.example.rickandmorty.main_page.model.Hero
import kotlinx.coroutines.flow.Flow

interface LocalHeroesRepository {
    suspend fun getAllLocalHeroes(): List<Hero>
    fun getAllLocalHeroesFlow(): Flow<List<Hero>>
    suspend fun saveAllHeroes(heroes: List<Hero>)
    suspend fun getHeroChanges(heroes: List<Hero>): List<Hero>
}