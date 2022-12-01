package com.example.rickandmorty.data.network

import retrofit2.Call
import retrofit2.http.GET

interface HeroesApi {

    @GET("character")
    suspend fun getAllHeroes(

    ): Call<HeroesListResponse>

}