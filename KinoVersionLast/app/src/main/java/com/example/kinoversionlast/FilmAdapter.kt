package com.example.kinoversionlast

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import kotlinx.android.synthetic.main.film_item.view.*

class FilmAdapter(val items: ArrayList<Film>, val context: Context) : RecyclerView.Adapter<FilmAdapter.ViewHolder>()
{

    override fun getItemCount(): Int
    {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.film_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int)
    {
        holder?.filmImage?.setImageResource(R.drawable.image_1)
        holder?.filmName?.text = items[position].name
        holder?.filmYear?.text = items[position].year
        holder?.filmGenre?.text = items[position].genre
        holder?.filmCountry?.text = items[position].country
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        var filmImage = itemView.findViewById<ImageView>(R.id.filmImage)
        val filmName  = itemView.findViewById<TextView>(R.id.filmName)
        val filmYear = itemView.findViewById<TextView>(R.id.filmYear)
        val filmGenre = itemView.findViewById<TextView>(R.id.filmGenre)
        val filmCountry = itemView.findViewById<TextView>(R.id.filmCountry)
    }

}