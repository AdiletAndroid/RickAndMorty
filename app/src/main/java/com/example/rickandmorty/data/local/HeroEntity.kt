package com.example.rickandmorty.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: String,
    val name: String,
    val gender: String,
    val status: String,
    val species: String
)