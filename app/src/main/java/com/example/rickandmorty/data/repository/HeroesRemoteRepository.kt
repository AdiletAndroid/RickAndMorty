package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.local.HeroDao
import com.example.rickandmorty.data.local.HeroEntity
import com.example.rickandmorty.data.network.HeroesApi
import com.example.rickandmorty.domain.model.HeroModel

class HeroesRemoteRepository(
    private val api: HeroesApi,
    private val dao: HeroDao
) : HeroesRepository {

    override suspend fun getAllHeroes(): List<HeroModel> {
        val response = api.getAllHeroes()
        return response.results.map { heroResponse ->
            HeroModel(
                id = heroResponse.id,
                image = heroResponse.image,
                name = heroResponse.name,
                gender = heroResponse.gender,
                status = heroResponse.status,
                species = heroResponse.species
            )
        }
    }

    override suspend fun saveHeroes(hero: HeroModel): List<HeroEntity> {
        dao.insert(
            heroEntity = HeroEntity(
                id = hero.id,
                image = hero.image,
                name = hero.name,
                gender = hero.gender,
                status = hero.status,
                species = hero.species
            )
        )
        return dao.getAllHeroes()
    }
}

