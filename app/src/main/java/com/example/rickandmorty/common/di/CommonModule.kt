package com.example.rickandmorty.common.di

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.R
import com.example.rickandmorty.main_page.api.MainPageApi
import com.example.rickandmorty.main_page.db.dao.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommonModule: InjectionModule {
    override fun create() = module {
        single {
            val context = get<Context>()
            Retrofit.Builder().baseUrl(context.getString(R.string.baseUrl))
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(MainPageApi::class.java)
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

