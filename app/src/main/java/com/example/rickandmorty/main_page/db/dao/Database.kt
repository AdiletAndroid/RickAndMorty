package com.example.rickandmorty.main_page.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.main_page.db.model.HeroEntity


@Database(entities = [HeroEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

}