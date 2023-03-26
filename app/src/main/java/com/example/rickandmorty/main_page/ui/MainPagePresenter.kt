package com.example.rickandmorty.main_page.ui

import com.example.rickandmorty.common.mvp.BasePresenter
import com.example.rickandmorty.main_page.interactor.HeroesDatabaseInteractor
import com.example.rickandmorty.main_page.interactor.HeroesInteractor
import com.example.rickandmorty.utils.NetworkUtils
import kotlinx.coroutines.launch

class MainPagePresenter(
    private val interactor: HeroesInteractor,
    private val databaseInteractor: HeroesDatabaseInteractor
) : BasePresenter<MainPageContract.View>(), MainPageContract.Presenter {

//    fun loadHeroes() {
//        val isNetworkConnecnted = NetworkUtils.isNetworkConnected()
//        if (isNetworkConnecnted) {
//            launch {
//                databaseInteractor.loadAllHeroes()
//                val heroes = databaseInteractor.getAllLocalHeroes()
//                view?.showHeroes(heroes)
//            }
//        } else {
//            launch {
//                val heroes = databaseInteractor.getAllLocalHeroes()
//                view?.showHeroes(heroes)
//            }
//        }
//    }

    override fun getHeroes() {
        launch {
            databaseInteractor.loadAllHeroes()
            val heroes = databaseInteractor.getAllLocalHeroes()
            view?.showHeroes(heroes)
        }
    }
}
