package com.example.rickandmorty.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HeroesApi {

    @GET("api/")

    fun getAllHeroes(
        @Header("Host") host: String = "rickandmortyapi.com/",
        @Query("characters") characters: String,
        @Query("episodes") episodes: String,
        @Query("locations") locations: String
    ): Call<ResponseModel>

}