package com.example.rickandmorty.presentation.presenters

import android.content.Context
import android.util.Log
import com.example.rickandmorty.domain.interactor.HeroesDatabaseInteractor
import com.example.rickandmorty.domain.interactor.HeroesInteractor
import com.example.rickandmorty.presentation.utils.NetworkUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HeroesListPresenter(
    private val interactor: HeroesInteractor,
    private val databaseInteractor: HeroesDatabaseInteractor,
    private val context: Context
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
        if (NetworkUtils.isNetworkConnected(context)) {
            launch {
                databaseInteractor.loadAllHeroes()
                val heroes = databaseInteractor.getAllLocalHeroes()
                view?.showHeroes(heroes)
            }
       }else{
            launch {
                val heroes = databaseInteractor.getAllLocalHeroes()
                view?.showHeroes(heroes)
            }
        }
    }
}
