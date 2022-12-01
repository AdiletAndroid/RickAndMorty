package com.example.rickandmorty.data.network

import com.google.gson.annotations.SerializedName

class HeroResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String
)