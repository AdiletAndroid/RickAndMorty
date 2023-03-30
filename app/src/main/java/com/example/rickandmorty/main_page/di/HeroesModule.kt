package com.example.rickandmorty.main_page.di

import com.example.rickandmorty.common.di.InjectionModule
import com.example.rickandmorty.main_page.db.repository.HeroesLocalRepository
import com.example.rickandmorty.main_page.db.repository.LocalHeroesRepository
import com.example.rickandmorty.main_page.interactor.HeroesInteractor
import com.example.rickandmorty.main_page.api.repository.HeroesRemoteRepository
import com.example.rickandmorty.main_page.api.repository.HeroesRepository
import com.example.rickandmorty.main_page.ui.MainPagePresenter
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


object HeroesModule : InjectionModule {

    override fun create() = module {
        singleOf(::HeroesRemoteRepository) bind HeroesRepository::class

        singleOf(::HeroesLocalRepository) bind LocalHeroesRepository::class

        factoryOf(::HeroesInteractor)

        viewModelOf(::MainPagePresenter)
    }
}