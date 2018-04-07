package com.example.kinoversionlast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.film_item.*

class MainActivity : AppCompatActivity() {

    val films : ArrayList<Film> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFilms()

        list_films.layoutManager = LinearLayoutManager(this)
        list_films.adapter = FilmAdapter(films, this)
        //  val recycler = findViewById<RecyclerView>(R.id.list_films)
        //  recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
    }
        fun addFilms(){
            films.add(Film("Терминатор 2", "2005", "Боевик","USA"))
            films.add(Film("Константин", "2005","Боевик, мистика","USA"))
            films.add(Film("Железный человек", "2005","Боевик, фантастика","USA"))
            films.add(Film("Зеленая миля", "2005","Драма, мистика","USA"))
        }
    }

