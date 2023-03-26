package com.example.rickandmorty.main_page.interactor

import com.example.rickandmorty.main_page.api.repository.HeroesRepository
import com.example.rickandmorty.main_page.model.Hero

class HeroesInteractor(
    private val repository: HeroesRepository
) {
    suspend fun getAllHeroes(): List<Hero> {
        return repository.getAllHeroes()
    }
}