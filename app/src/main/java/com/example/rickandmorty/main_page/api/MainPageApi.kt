package com.example.rickandmorty.main_page.api

import com.example.rickandmorty.main_page.api.model.HeroesListResponse
import retrofit2.http.GET

interface MainPageApi {

    @GET("character")
    suspend fun getAllHeroes(): HeroesListResponse

}