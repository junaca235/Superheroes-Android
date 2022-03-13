package com.example.superheroes.converter

import androidx.room.TypeConverter
import com.example.superheroes.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Appendable
import java.lang.reflect.Type
import kotlin.Result


class Converters {

        @TypeConverter
        fun fromString(value: String?): ArrayList<String> {
            val listType: Type
                    = object : TypeToken<ArrayList<String?>?>() {}.type
            return Gson().fromJson(value, listType)
        }
        @TypeConverter
        fun fromArrayList(list: ArrayList<String?>?): String {
            val gson = Gson()
            return gson.toJson(list)
        }
        /*
        @TypeConverter
        fun fromList (list: ArrayList<Superhero?>?): String{
            return Gson().toJson(list)
        }*/


        @TypeConverter
        fun fromPowerstats(powerstats: Powerstats):String{
            return Gson().toJson(powerstats.toString())
        }
        @TypeConverter
        fun stringToPowerstats(string: String): Powerstats = Gson().fromJson(string, Powerstats::class.java)

        @TypeConverter
        fun fromSuperHero(superHero: Superhero):String{
            return Gson().toJson(superHero.toString())
        }
        @TypeConverter
        fun stringToSuperHero(string: String): Superhero = Gson().fromJson(string, Superhero::class.java)

        @TypeConverter
        fun fromBiography(biography: Biography):String{
            return Gson().toJson(biography.toString())
        }
        @TypeConverter
        fun stringToBiography(string: String): Biography = Gson().fromJson(string, Biography::class.java)


        @TypeConverter
        fun fromAppearance(appendable: Appearance):String{
            return Gson().toJson(appendable.toString())
        }
        @TypeConverter
        fun stringToAppearance(string: String): Appearance = Gson().fromJson(string, Appearance::class.java)


        @TypeConverter
        fun fromWork(work: Work):String{
            return Gson().toJson(work.toString())
        }
        @TypeConverter
        fun stringToWork(string: String): Work = Gson().fromJson(string, Work::class.java)


        @TypeConverter
        fun fromConnections(connections: Connections):String{
            return Gson().toJson(connections.toString())
        }
        @TypeConverter
        fun stringToConnections(string: String): Connections = Gson().fromJson(string, Connections::class.java)


        @TypeConverter
        fun fromImage(image: Image):String{
            return Gson().toJson(image.toString())
        }
        @TypeConverter
        fun stringToImage(string: String): Image = Gson().fromJson(string, Image::class.java)
}