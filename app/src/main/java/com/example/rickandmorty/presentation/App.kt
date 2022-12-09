package com.example.rickandmorty.presentation

import android.app.Application
import com.example.rickandmorty.di.CommonModule
import com.example.rickandmorty.di.HeroesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                HeroesModule.create(),
                CommonModule.create()
            )
        }
    }
}