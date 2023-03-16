package com.example.rickandmorty.di

import androidx.room.Room
import com.example.rickandmorty.constants.Constants
import com.example.rickandmorty.data.local.AppDatabase
import com.example.rickandmorty.data.network.HeroesApi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommonModule {

    fun create() = module {
        single {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(HeroesApi::class.java)
        }

        single {
            Room.databaseBuilder(
                androidApplication(),
                AppDatabase::class.java,
                "database"
            ).build()
        }

        single {
            val database = get<AppDatabase>()
            database.heroDao()
        }

    }
}

