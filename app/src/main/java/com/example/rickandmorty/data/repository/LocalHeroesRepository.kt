package com.example.rickandmorty.data.repository

import com.example.rickandmorty.domain.model.HeroModel

interface LocalHeroesRepository {

    suspend fun getAllLocalHeroes(): List<HeroModel>

    suspend fun saveAllHeroes(heroes: List<HeroModel>)

}