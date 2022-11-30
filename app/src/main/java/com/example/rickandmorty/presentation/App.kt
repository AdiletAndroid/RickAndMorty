package com.example.rickandmorty.presentation

import android.app.Application
import com.example.rickandmorty.data.network.HeroesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    fun heroesApi(): HeroesApi {
        return Retrofit.Builder().baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(HeroesApi::class.java)

    }
}