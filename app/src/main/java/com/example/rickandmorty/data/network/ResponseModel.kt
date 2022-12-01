package com.example.rickandmorty.data.network


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("characters")
    val characters: String,
    @SerializedName("episodes")
    val episodes: String,
    @SerializedName("locations")
    val locations: String
)