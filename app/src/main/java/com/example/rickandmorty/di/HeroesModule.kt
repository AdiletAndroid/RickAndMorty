package com.example.rickandmorty.di

import com.example.rickandmorty.data.repository.HeroesRemoteRepository
import com.example.rickandmorty.data.repository.HeroesRepository
import com.example.rickandmorty.data.repository.HeroesDatabaseRepository
import com.example.rickandmorty.data.repository.LocalHeroesRepository
import com.example.rickandmorty.domain.interactor.HeroesDatabaseInteractor
import com.example.rickandmorty.domain.interactor.HeroesInteractor
import com.example.rickandmorty.presentation.presenters.HeroInfoPresenter
import com.example.rickandmorty.presentation.presenters.HeroesListPresenter
import com.example.rickandmorty.presentation.utils.NetworkUtils
import org.koin.dsl.bind
import org.koin.dsl.module


object HeroesModule {

    fun create() = module {
        single {
            HeroesRemoteRepository(get())
        } bind HeroesRepository::class

        single {
            HeroesDatabaseRepository(get())
        } bind LocalHeroesRepository::class

        single {
            NetworkUtils
        } bind NetworkUtils::class

        factory {
            HeroesInteractor(get())
        }

        factory {
            HeroesDatabaseInteractor(get(), get())
        }

        factory {
            HeroesListPresenter(get(), get(), get())
        }

        factory {
            HeroInfoPresenter(get())
        }
    }
}