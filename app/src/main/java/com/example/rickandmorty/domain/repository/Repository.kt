package com.example.rickandmorty.domain.repository

import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllHeroes(): Flow<Unit>

    fun getHeroInfo(): Flow<Unit>

}