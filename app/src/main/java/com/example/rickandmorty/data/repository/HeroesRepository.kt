package com.example.rickandmorty.data.repository

import com.example.rickandmorty.domain.model.HeroModel

interface HeroesRepository {

    suspend fun getAllHeroes(): List<HeroModel>

}