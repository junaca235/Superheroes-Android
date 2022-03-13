package com.example.superheroes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroes.R
import com.example.superheroes.Superhero
import com.example.superheroes.SuperheroResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent.extras
        val hero = intent!!.getSerializable("Superhero") as Superhero

        putDetails(hero)
    }

    private fun putDetails(hero: Superhero){


        Picasso.get().load(hero.image?.url).into(im_hero)

        tv_fullName.text = hero.biography?.fullName
        tv_alterEgos.text = hero.biography?.alterEgos
        tv_aliases.text = hero.biography?.aliases.toString()
        tv_placfeOfBirth.text = hero.biography?.placeOfBirth
        tv_firstAppereance.text = hero.biography?.firstAppearance
        tv_publisher.text = hero.biography?.publisher
        tv_aligment.text = hero.biography?.alignment

        tv_intelligence.text = hero.powerstats?.intelligence
        tv_strength.text = hero.powerstats?.strength
        tv_speed.text = hero.powerstats?.speed
        tv_durability.text = hero.powerstats?.durability
        tv_power.text = hero.powerstats?.power
        tv_combat.text = hero.powerstats?.power

        tv_gender.text = hero.appearance?.gender
        tv_race.text = hero.appearance?.race
        tv_height.text = hero.appearance?.height.toString()
        tv_weight.text = hero.appearance?.weight.toString()
        tv_eyeColor.text = hero.appearance?.eyeColor
        tv_hairColor.text = hero.appearance?.hairColor

        tv_occupation.text = hero.work?.occupation
        tv_baseOperation.text = hero.work?.base
        tv_groupAffiliation.text = hero.connections?.groupAffiliation
        tv_relatives.text = hero.connections?.relatives


    }
}