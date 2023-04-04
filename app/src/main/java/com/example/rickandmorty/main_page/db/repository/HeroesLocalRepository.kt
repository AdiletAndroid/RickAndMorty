package com.example.rickandmorty.main_page.db.repository

import com.example.rickandmorty.main_page.db.dao.HeroDao
import com.example.rickandmorty.main_page.db.model.HeroesEntityConverter
import com.example.rickandmorty.main_page.model.Hero

class HeroesLocalRepository(
    private val db: HeroDao
) : LocalHeroesRepository {
    override suspend fun getAllLocalHeroes() = HeroesEntityConverter.fromEntity(db.getAllHeroes())
    override suspend fun saveAllHeroes(heroes: List<Hero>) {
        val heroEntities = HeroesEntityConverter.toEntity(heroes)
        db.insert(heroEntities)
    }

    override suspend fun getHeroChanges(heroes: List<Hero>): List<Hero> {
        val localHeroes = getAllLocalHeroes()
        val changedHeroes = mutableListOf<Hero>()
        for (hero in heroes) {
            val localHero = localHeroes.find { it.id == hero.id }
            if (localHero == null || localHero != hero) {
                changedHeroes.add(hero)
            }
        }
        return changedHeroes
    }
}