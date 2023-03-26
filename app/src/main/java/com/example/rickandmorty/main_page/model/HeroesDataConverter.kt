package com.example.rickandmorty.main_page.model

import com.example.rickandmorty.main_page.api.model.HeroesListResponse

object HeroesDataConverter {

    fun fromNetwork(response: HeroesListResponse) = response.results.map { heroResponse ->
        Hero(
            id = heroResponse.id,
            image = heroResponse.image,
            name = heroResponse.name,
            gender = heroResponse.gender,
            status = heroResponse.status,
            species = heroResponse.species
        )
    }
}
