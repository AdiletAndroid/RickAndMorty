package com.example.rickandmorty.di

import com.example.rickandmorty.data.repository.HeroesRemoteRepository
import com.example.rickandmorty.data.repository.HeroesRepository
import com.example.rickandmorty.domain.interactor.HeroesInteractor
import com.example.rickandmorty.presentation.presenters.HeroInfoPresenter
import com.example.rickandmorty.presentation.presenters.HeroesListPresenter
import org.koin.core.scope.get
import org.koin.dsl.bind
import org.koin.dsl.module


object HeroesModule {

    fun create() = module {
        single {
            HeroesRemoteRepository(get())
        } bind HeroesRepository::class

        factory {
            HeroesInteractor(get())
        }

        factory {
            HeroesListPresenter(get())
        }

        factory {
            HeroInfoPresenter(get())
        }
    }
}