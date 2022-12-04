package com.example.rickandmorty.presentation.presenters

import com.example.rickandmorty.domain.model.HeroModel

interface HeroesView {

    fun showHeroes(heroes : List<HeroModel>)

}