package com.example.rickandmorty.presentation.presenter

import com.example.rickandmorty.domain.useCases.GetAllHeroesUseCase
import com.example.rickandmorty.domain.useCases.HeroInfoUseCase

class Presenter {

    fun getAllHeroes(){
        GetAllHeroesUseCase().execute()
    }

    fun getHeroInfo(){
        HeroInfoUseCase().execute()
    }

}