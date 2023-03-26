package com.example.rickandmorty.main_page.api.model

import com.google.gson.annotations.SerializedName
class HeroesListResponse(
    @SerializedName("results")
    val results: List<HeroResponse>
)