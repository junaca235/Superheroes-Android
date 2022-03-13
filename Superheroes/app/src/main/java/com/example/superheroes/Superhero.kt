package com.example.superheroes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Superheros :Serializable{
    @SerializedName("response")
    @Expose
    var response: String? = null

    @SerializedName("results-for")
    @Expose
    var resultsFor: String? = null

    @SerializedName("results")
    @Expose
    var results: List<Superhero>? = null

}

@Entity(tableName = "RESULT")
class Superhero :Serializable{

    @PrimaryKey(autoGenerate = false)
    var nid:Long? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("powerstats")
    @Expose
    var powerstats: Powerstats? = null

    @SerializedName("biography")
    @Expose
    var biography: Biography? = null

    @SerializedName("appearance")
    @Expose
    var appearance: Appearance? = null

    @SerializedName("work")
    @Expose
    var work: Work? = null

    @SerializedName("connections")
    @Expose
    var connections: Connections? = null

    @SerializedName("image")
    @Expose
    var image: Image? = null

}

@Entity(tableName = "APPEARANCE")
class Appearance : Serializable{
    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("race")
    @Expose
    var race: String? = null

    @SerializedName("height")
    @Expose
    var height: List<String>? = null

    @SerializedName("weight")
    @Expose
    var weight: List<String>? = null

    @SerializedName("eye-color")
    @Expose
    var eyeColor: String? = null

    @SerializedName("hair-color")
    @Expose
    var hairColor: String? = null

}

@Entity(tableName = "BIOGRAPHY")
class Biography : Serializable{
    @SerializedName("full-name")
    @Expose
    var fullName: String? = null

    @SerializedName("alter-egos")
    @Expose
    var alterEgos: String? = null

    @SerializedName("aliases")
    @Expose
    var aliases: List<String>? = null

    @SerializedName("place-of-birth")
    @Expose
    var placeOfBirth: String? = null

    @SerializedName("first-appearance")
    @Expose
    var firstAppearance: String? = null

    @SerializedName("publisher")
    @Expose
    var publisher: String? = null

    @SerializedName("alignment")
    @Expose
    var alignment: String? = null

}

@Entity(tableName = "CONNECTIONS")
class Connections: Serializable {
    @SerializedName("group-affiliation")
    @Expose
    var groupAffiliation: String? = null

    @SerializedName("relatives")
    @Expose
    var relatives: String? = null

}

@Entity(tableName = "IMAGE")
class Image: Serializable {
    @SerializedName("url")
    @Expose
    var url: String? = null

}

@Entity(tableName = "POWERSTATS")
class Powerstats: Serializable {
    @SerializedName("intelligence")
    @Expose
    var intelligence: String? = null

    @SerializedName("strength")
    @Expose
    var strength: String? = null

    @SerializedName("speed")
    @Expose
    var speed: String? = null

    @SerializedName("durability")
    @Expose
    var durability: String? = null

    @SerializedName("power")
    @Expose
    var power: String? = null

    @SerializedName("combat")
    @Expose
    var combat: String? = null

}

@Entity(tableName = "WORK")
class Work: Serializable {
    @SerializedName("occupation")
    @Expose
    var occupation: String? = null

    @SerializedName("base")
    @Expose
    var base: String? = null

}