package com.example.kinoversionlast

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Film
(
        val name: String,
        val genre: String,
        val description: String,
        val country: String,
        val year: String,
        @PrimaryKey
        val picture: String
)
{
    class List : ArrayList<Film>()
}