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
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hero

        if (id != other.id) return false
        if (image != other.image) return false
        if (name != other.name) return false
        if (gender != other.gender) return false
        if (status != other.status) return false
        if (species != other.species) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + image.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + species.hashCode()
        return result
    }
}