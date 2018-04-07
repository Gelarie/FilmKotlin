package com.example.kinoversionlast

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface FilmDao {

    @Query("SELECT * FROM Film")
    fun getAll(): List<Film>

    @Insert
    fun insertAll(films: List<Film>)
}