package com.example.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter (private val superheros: List<Superhero>, private val heroListener: HeroListener) : RecyclerView.Adapter<HeroviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroviewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return HeroviewHolder(layoutInflater.inflate(R.layout.distribucion, parent, false), heroListener)
    }

    override fun getItemCount(): Int  = superheros.size

    override fun onBindViewHolder(holder: HeroviewHolder, position: Int) {
        val item = superheros[position]
        //holder.bind(item.image)
        holder.bind(item)
    }

    //INTERFAZ LISTENER
    interface HeroListener{
        fun listen(hero: Superhero)
    }
}