package com.example.rickandmorty.data.network

import com.example.rickandmorty.constants.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    fun heroesApi(): HeroesApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(HeroesApi::class.java)
    }
}