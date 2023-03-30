package com.example.rickandmorty.main_page.api.repository

import com.example.rickandmorty.main_page.api.MainPageApi
import com.example.rickandmorty.main_page.model.Hero
import com.example.rickandmorty.main_page.model.HeroesDataConverter

class HeroesRemoteRepository(
    private val api: MainPageApi
) : HeroesRepository {
    override suspend fun getAllHeroes(page: Int): List<Hero> {
        return HeroesDataConverter.fromNetwork(api.getAllHeroes(page))
    }
}

