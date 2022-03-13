package com.example.superheroes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.distribucion.view.*


class HeroviewHolder (view: View, val listener: SuperheroAdapter.HeroListener): RecyclerView.ViewHolder(view){

    fun bind(superhero: Superhero) {
        Picasso.get().load(superhero.image!!.url).into(itemView.iv_hero)
        itemView.tv_nombre.text = superhero.name
        itemView.tv_nombreCompleto.text = superhero.biography!!.fullName
        itemView.setOnClickListener{ listener.listen(superhero)}
    }
}