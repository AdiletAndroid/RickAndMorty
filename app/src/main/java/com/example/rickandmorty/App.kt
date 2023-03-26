package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.common.di.CommonModule
import com.example.rickandmorty.main_page.di.HeroesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        stopKoin()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    HeroesModule.create(),
                    CommonModule.create()
                )

            )
        }
    }
}