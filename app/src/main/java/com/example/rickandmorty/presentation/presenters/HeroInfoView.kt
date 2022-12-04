package com.example.rickandmorty.presentation.presenters

import com.example.rickandmorty.domain.model.HeroModel


interface HeroInfoView {

    fun showHeroInfo(heroes : List<HeroModel>)

}