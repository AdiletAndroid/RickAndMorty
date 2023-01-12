package com.example.rickandmorty.presentation.presenters

import com.example.rickandmorty.domain.interactor.HeroesInteractor
import kotlinx.coroutines.*
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

    fun loadHeroes() = runBlocking {
        launch(Dispatchers.IO) {
            val heroes = interactor.getAllHeroes()
            view?.showHeroes(heroes)
        }
    }
}