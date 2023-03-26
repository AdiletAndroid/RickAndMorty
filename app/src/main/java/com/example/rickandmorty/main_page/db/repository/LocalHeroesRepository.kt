package com.example.rickandmorty.main_page.db.repository

import com.example.rickandmorty.main_page.model.Hero

interface LocalHeroesRepository {
    suspend fun getAllLocalHeroes(): List<Hero>

    suspend fun saveAllHeroes(heroes: List<Hero>)
}