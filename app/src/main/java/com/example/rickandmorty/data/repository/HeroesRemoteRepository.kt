package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.local.HeroDao
import com.example.rickandmorty.data.local.HeroEntity
import com.example.rickandmorty.data.network.HeroesApi
import com.example.rickandmorty.domain.model.HeroModel

class HeroesRemoteRepository(
    private val api: HeroesApi,
    private val db: HeroDao
) : HeroesRepository {

    override suspend fun getAllHeroes(): List<HeroModel> {
        val heroes = db.getAllHeroes()
        if (heroes.isNotEmpty()) {
            return heroes.map { entity ->
                HeroModel(
                    id = entity.id,
                    image = entity.image,
                    name = entity.name,
                    gender = entity.gender,
                    status = entity.status,
                    species = entity.species
                )
            }
        }

        val response = api.getAllHeroes()

        response.results.forEach {
            val entity = HeroEntity(
                id = it.id,
                image = it.image,
                name = it.name,
                gender = it.gender,
                status = it.status,
                species = it.species
            )
            db.insert(entity)
        }

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
}

