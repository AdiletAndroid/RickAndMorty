package com.example.rickandmorty.main_page.db.model

import com.example.rickandmorty.main_page.model.Hero

object HeroesEntityConverter {
    fun fromEntity(entity: List<HeroEntity>): List<Hero> {
        return entity.map {data ->
            Hero(
                id = data.id,
                image = data.image,
                name = data.name,
                gender = data.gender,
                status = data.status,
                species = data.species
            )
        }
    }

    fun toEntity(data: List<Hero>): List<HeroEntity>{
        return data.map {hero ->
            HeroEntity(
                id = hero.id,
                image = hero.image,
                name = hero.name,
                gender = hero.gender,
                status = hero.status,
                species = hero.species
            )
        }
    }
}