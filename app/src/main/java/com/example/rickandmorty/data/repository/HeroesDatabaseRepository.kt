package com.example.rickandmorty.data.repository

import android.util.Log
import com.example.rickandmorty.data.local.HeroDao
import com.example.rickandmorty.data.local.HeroEntity
import com.example.rickandmorty.domain.model.HeroModel

class HeroesDatabaseRepository(
    private val db: HeroDao,
) : LocalHeroesRepository {

    override suspend fun getAllLocalHeroes(): List<HeroModel> {

        val heroes = db.getAllHeroes()

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

    override suspend fun saveAllHeroes(heroes: List<HeroModel>) {

        val heroEntities = heroes.map {
            HeroEntity(
                id = it.id,
                image = it.image,
                name = it.name,
                gender = it.gender,
                status = it.status,
                species = it.species
            )
        }
        db.insert(heroEntities)
        Log.d("Tag", heroes.toString())
    }
}