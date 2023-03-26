package com.example.rickandmorty.main_page.interactor

import com.example.rickandmorty.main_page.api.repository.HeroesRepository
import com.example.rickandmorty.main_page.db.repository.LocalHeroesRepository
import com.example.rickandmorty.main_page.model.Hero

class HeroesDatabaseInteractor(
    private val repository: HeroesRepository,
    private val localRepository: LocalHeroesRepository
) {

    suspend fun loadAllHeroes() {
        val heroes = repository.getAllHeroes()
        localRepository.saveAllHeroes(heroes)
    }

    suspend fun getAllLocalHeroes(): List<Hero> {
        return localRepository.getAllLocalHeroes()
    }
}