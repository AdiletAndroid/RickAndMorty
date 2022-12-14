package com.example.rickandmorty.presentation.presenters

import com.example.rickandmorty.data.local.HeroEntity
import com.example.rickandmorty.domain.model.HeroModel

interface HeroesListView {

    fun showHeroes(heroes: List<HeroModel>)

    fun saveHeroes(hero: List<HeroEntity>)

}