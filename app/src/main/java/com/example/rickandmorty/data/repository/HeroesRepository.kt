package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.local.HeroEntity
import com.example.rickandmorty.domain.model.HeroModel

interface HeroesRepository {

    suspend fun getAllHeroes(): List<HeroModel>

    suspend fun saveHeroes(hero: HeroModel): List<HeroEntity>
}