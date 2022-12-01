package com.example.rickandmorty.domain.interactor

import com.example.rickandmorty.data.repository.HeroesRepository
import com.example.rickandmorty.domain.model.HeroModel


class HeroesInteractor(
    private val repository: HeroesRepository
) {

    suspend fun getAllHeroes(): List<HeroModel>{
        return repository.getAllHeroes()
    }

}