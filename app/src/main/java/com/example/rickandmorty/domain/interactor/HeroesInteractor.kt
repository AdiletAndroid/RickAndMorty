package com.example.rickandmorty.domain.interactor

import com.example.rickandmorty.data.local.HeroEntity
import com.example.rickandmorty.data.repository.HeroesRepository
import com.example.rickandmorty.domain.model.HeroModel


class HeroesInteractor(

    private val repository: HeroesRepository

) {

    suspend fun getAllHeroes(): List<HeroModel>{
        return repository.getAllHeroes()
    }

    suspend fun saveHeroes(heroModel: HeroModel): List<HeroEntity> {
        return repository.saveHeroes(heroModel)
    }

}