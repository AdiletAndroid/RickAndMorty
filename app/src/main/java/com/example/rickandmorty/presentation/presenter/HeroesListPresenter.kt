package com.example.rickandmorty.presentation.presenter

import com.example.rickandmorty.domain.interactor.HeroesInteractor

class HeroesListPresenter(
    private val interactor: HeroesInteractor
) {

    private var view: HeroesView? = null

    fun attachView(view: HeroesView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun loadHeroes() {

    }

}