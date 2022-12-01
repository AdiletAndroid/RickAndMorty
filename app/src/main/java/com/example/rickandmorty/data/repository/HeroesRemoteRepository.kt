package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.network.HeroesApi
import com.example.rickandmorty.domain.model.HeroModel

class HeroesRemoteRepository(
    private val api: HeroesApi
) : HeroesRepository {

    override suspend fun getAllHeroes(): List<HeroModel> {
        val response = api.getAllHeroes()
        return response.results.map { heroResponse ->
            HeroModel(
                id = heroResponse.id,
                image = heroResponse.image,
                name = heroResponse.name,
                gender = heroResponse.gender
            )
        }
    }
}