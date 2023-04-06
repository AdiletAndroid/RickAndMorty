package com.example.rickandmorty.main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val id: Int,
    val image: String,
    val name: String,
    val gender: String,
    val status: String,
    val species: String
) : Parcelable