package com.example.kinoversionlast

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val films = Film.List()




        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        launch(UI) {

            val cachedFilms = loadingPhotosFromCache(application as App).await()
            if (cachedFilms.isNotEmpty()) {
                films.addAll(cachedFilms)
                recyclerView.adapter.notifyDataSetChanged()
            } else {
                val cloudPhotosJob = loadingPhotosFromCloud()
                cloudPhotosJob.start()
                val cloudPhotos = cloudPhotosJob.await()
                savePhotos(application as App, cloudPhotos)
                films.addAll(cloudPhotos)
                recyclerView.adapter.notifyDataSetChanged()
            }
        }





    }

    data class GitHubRepositoryInfo(val year: String, val name: String, val country: String, val description: String, val genre: String, val picture: String) {

        class List : ArrayList<GitHubRepositoryInfo>()
    }





    class Adapter(val values: Film.List, val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {


        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.textViewName?.text = values[position].name
            holder?.textViewYear?.text = values[position].year
            holder?.textViewCountry?.text = values[position].country
            holder?.textViewDescription?.text = values[position].description
            holder?.textViewGenre?.text = values[position].genre


            Picasso.with(context).load(values[position].picture).into(holder?.imageView)





        }

        override fun getItemCount() = values.size

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.activity_text_item_list, parent, false)
            return ViewHolder(itemView)
        }

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            var textViewName: TextView? = null
            var textViewYear: TextView? = null
            var textViewCountry: TextView? = null
            var textViewDescription: TextView? = null
            var textViewGenre: TextView? = null
            var imageView: ImageView? = null


            init {
                textViewName = itemView?.findViewById(R.id.textViewName)
                textViewYear = itemView?.findViewById(R.id.textViewYear)
                textViewCountry = itemView?.findViewById(R.id.textViewCountry)
                textViewDescription = itemView?.findViewById(R.id.textViewDescription)
                textViewGenre = itemView?.findViewById(R.id.textViewGenre)
                imageView = itemView?.findViewById(R.id.imageView)

            }
        }


    }
}