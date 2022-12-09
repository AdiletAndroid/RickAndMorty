package com.example.rickandmorty.domain.model

import java.io.Serializable

data class HeroModel(
    val id: Int,
    val image: String,
    val name: String,
    val gender: String,
    val status: String,
    val species: String
) : Serializable