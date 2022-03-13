package com.example.superheroes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "SUPERHEROSRESPONSE")
data class SuperheroResponse (
    var nid : Long? = null,
    @SerializedName("response") var response: String = "",
    //result-for
    //result (Superhero)
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id: String  ="",
    @SerializedName("name") var name: String = "",

    @SerializedName("intelligence") var intelligence:  String = "",
    @SerializedName("strength") var strength:  String = "",
    @SerializedName("speed") var speed:  String = "",
    @SerializedName("durability") var durability:  String = "",
    @SerializedName("power") var power:  String = "",
    @SerializedName("combat") var combat:  String = "",

    @SerializedName("full-name") var fullName: String = "",
    @SerializedName("alter-egos") var alterEgos: String = "",
    @SerializedName("aliases") var aliases: List<String>,       ///---
    @SerializedName("place-of-birth") var placeOfBirth: String = "",
    @SerializedName("publisher") var firstAppereance: String = "",
    @SerializedName("publisher") var publisher: String = "",
    @SerializedName("alignment") var alignment: String = "",

    @SerializedName("gender") var gender: String = "",
    @SerializedName("race") var race: String = "",
    @SerializedName("height") var height: List<String>,         ///---
    @SerializedName("weight") var weight: List<String>,         ///---
    @SerializedName("eye-color") var eyeColor: String = "",
    @SerializedName("hair-color") var hairColor: String = "",

    @SerializedName("occupation") var occupation: String = "",
    @SerializedName("base") var baseOfOperation: String = "",
    @SerializedName("group-affiliation") var groupAffinity: String = "",
    @SerializedName("relatives") var relatives: String = "",
    @SerializedName("url") var image: String = ""

): Serializable