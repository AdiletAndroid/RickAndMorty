package com.example.rickandmorty.domain.useCases

import com.example.rickandmorty.domain.model.HeroModel

class HeroInfoUseCase {

    fun execute() : HeroModel {
        return HeroModel(1, "url", "Morty", "Male")
    }

}