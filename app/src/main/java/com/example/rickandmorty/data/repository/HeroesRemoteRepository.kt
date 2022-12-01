package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.network.HeroesApi
import com.example.rickandmorty.domain.model.HeroModel

class HeroesRemoteRepository(
    private val api: HeroesApi
) : HeroesRepository {

    override suspend fun getAllHeroes(): List<HeroModel> {
        TODO("Not yet implemented")
    }
}