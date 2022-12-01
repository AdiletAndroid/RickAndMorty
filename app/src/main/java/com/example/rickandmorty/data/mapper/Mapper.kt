package com.example.rickandmorty.data.mapper

import com.example.rickandmorty.data.local.HeroEntity
import com.example.rickandmorty.domain.model.HeroModel


fun HeroModel.toHeroEntity() = HeroEntity(
    id,
    image,
    name,
    gender
)

fun HeroEntity.toHeroModel() = HeroModel(
    id,
    image,
    name,
    gender
)


