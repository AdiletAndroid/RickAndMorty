package com.example.rickandmorty.presentation.presenters

import com.example.rickandmorty.domain.interactor.HeroesInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class HeroInfoPresenter(
    private val interactor: HeroesInteractor
) : CoroutineScope {

    override val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.Main.immediate

    private var view: HeroInfoView? = null

    fun attachView(view: HeroInfoView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }
}