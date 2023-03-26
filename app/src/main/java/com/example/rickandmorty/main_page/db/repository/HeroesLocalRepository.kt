package com.example.rickandmorty.main_page.db.repository

import com.example.rickandmorty.main_page.db.dao.HeroDao
import com.example.rickandmorty.main_page.db.model.HeroesEntityConverter
import com.example.rickandmorty.main_page.model.Hero

class HeroesLocalRepository(
    private val db: HeroDao,
) : LocalHeroesRepository {
    override suspend fun getAllLocalHeroes() = HeroesEntityConverter.fromEntity(db.getAllHeroes())
    override suspend fun saveAllHeroes(heroes: List<Hero>) {
        val heroEntities = HeroesEntityConverter.toEntity(heroes)
        db.insert(heroEntities)
    }
}