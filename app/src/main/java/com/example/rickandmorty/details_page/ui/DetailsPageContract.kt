package com.example.rickandmorty.details_page.ui

import com.example.rickandmorty.common.mvp.MvpView

interface DetailsPageContract {

    interface View : MvpView{
        fun showHeroInfo()
    }
}