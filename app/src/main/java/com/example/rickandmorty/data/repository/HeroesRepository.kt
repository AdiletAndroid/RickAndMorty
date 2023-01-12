package com.example.rickandmorty.data.repository

import com.example.rickandmorty.domain.model.HeroModel
import kotlinx.coroutines.flow.Flow

interface HeroesRepository {

    suspend fun getAllHeroes(): List<HeroModel>


}