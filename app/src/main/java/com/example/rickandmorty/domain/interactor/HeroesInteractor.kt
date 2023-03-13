package com.example.rickandmorty.domain.interactor

import com.example.rickandmorty.data.repository.HeroesRepository
import com.example.rickandmorty.data.repository.LocalHeroesRepository
import com.example.rickandmorty.domain.model.HeroModel

class HeroesInteractor(
    private val repository: HeroesRepository,
    private val localRepository: LocalHeroesRepository
) {

    suspend fun loadAllHeroes() {
        val heroes = repository.getAllHeroes()

        localRepository.saveAllHeroes(heroes)
    }

    suspend fun getAllLocalHeroes(): List<HeroModel> {
        return localRepository.getAllLocalHeroes()
    }

}