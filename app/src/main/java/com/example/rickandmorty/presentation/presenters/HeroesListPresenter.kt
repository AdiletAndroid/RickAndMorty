package com.example.rickandmorty.presentation.presenters

import com.example.rickandmorty.domain.interactor.HeroesInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HeroesListPresenter(
    private val interactor: HeroesInteractor
) : CoroutineScope {

    override val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.Main.immediate

    private var view: HeroesListView? = null

    fun attachView(view: HeroesListView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun loadHeroes() {
        launch {
            val heroes = interactor.getAllHeroes()
            view?.showHeroes(heroes)
        }
    }

    fun saveHeroesList() {
        launch {
            val data = interactor.saveHeroes()
            view?.saveHeroes(data)
        }
    }
}