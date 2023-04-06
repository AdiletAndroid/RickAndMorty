package com.example.rickandmorty.main_page.interactor

import com.example.rickandmorty.main_page.api.repository.HeroesRepository
import com.example.rickandmorty.main_page.db.repository.LocalHeroesRepository
import com.example.rickandmorty.main_page.model.Hero
import kotlinx.coroutines.flow.Flow

class HeroesInteractor(
    private val repository: HeroesRepository,
    private val localRepository: LocalHeroesRepository
) {

    suspend fun loadAllHeroes(page: Int) {
        val heroes = repository.getAllHeroes(page)
        val changedHeroes = localRepository.getHeroChanges(heroes)
        if (changedHeroes.isNotEmpty()) {
            localRepository.saveAllHeroes(heroes)
        }
    }

    suspend fun getAllLocalHeroes(): List<Hero> {
        return localRepository.getAllLocalHeroes()
    }

    fun getAllLocalHeroesFlow(): Flow<List<Hero>> {
        return localRepository.getAllLocalHeroesFlow()
    }
}