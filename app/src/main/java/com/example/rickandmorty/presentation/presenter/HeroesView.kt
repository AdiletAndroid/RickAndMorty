package com.example.rickandmorty.presentation.presenter

import com.example.rickandmorty.domain.model.HeroModel

interface HeroesView {

    fun showHeroes(heroes : List<HeroModel>)

}