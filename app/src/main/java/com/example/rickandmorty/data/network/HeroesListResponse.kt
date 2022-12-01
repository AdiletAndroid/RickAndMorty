package com.example.rickandmorty.data.network


import com.google.gson.annotations.SerializedName

class HeroesListResponse(
    @SerializedName("results")
    val results: List<HeroResponse>
)