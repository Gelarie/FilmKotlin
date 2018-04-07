package com.example.kinoversionlast

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Film::class], version = 1)
abstract class FilmDatabase : RoomDatabase() {

    abstract fun filmsDao(): FilmDao
}
