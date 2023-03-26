package com.example.rickandmorty.main_page.api.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Query

class HeroResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String
)