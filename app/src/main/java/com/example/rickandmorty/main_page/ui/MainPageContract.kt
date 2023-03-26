package com.example.rickandmorty.main_page.ui

import com.example.rickandmorty.common.mvp.MvpPresenter
import com.example.rickandmorty.common.mvp.MvpView
import com.example.rickandmorty.main_page.model.Hero

interface MainPageContract {

    interface View : MvpView{
        fun showHeroes(heroes: List<Hero>)
    }

    interface Presenter: MvpPresenter<View>{
        fun getHeroes()
    }

}