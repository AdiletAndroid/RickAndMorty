package com.example.rickandmorty.main_page.ui

import com.example.rickandmorty.common.mvp.BasePresenter
import com.example.rickandmorty.common.ui.ConnectivityChecker
import com.example.rickandmorty.main_page.interactor.HeroesInteractor
import kotlinx.coroutines.launch

class MainPagePresenter(
    private val interactor: HeroesInteractor,
    private val connectivityChecker: ConnectivityChecker
) : BasePresenter<MainPageContract.View>(), MainPageContract.Presenter {

    override fun getHeroes(page: Int) {

        launch {
            if (connectivityChecker.isInternetAvailable()) {
                interactor.loadAllHeroes(page)
            }
            val heroes = interactor.getAllLocalHeroes()
            view?.showHeroes(heroes)
        }
    }
}

