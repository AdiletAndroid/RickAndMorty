package com.example.rickandmorty.main_page.api.repository

import com.example.rickandmorty.main_page.model.Hero

interface HeroesRepository {
    suspend fun getAllHeroes(): List<Hero>
}