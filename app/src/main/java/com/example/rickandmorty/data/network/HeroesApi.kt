package com.example.rickandmorty.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroesApi {

    @GET("api/character")

    fun getAllHeroes()

}