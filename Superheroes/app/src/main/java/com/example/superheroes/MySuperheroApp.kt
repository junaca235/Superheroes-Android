package com.example.superheroes

import android.app.Application
import androidx.room.Room


class MySuperheroApp: Application() {

    companion object{
        public lateinit var database: TaskDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, TaskDatabase::class.java, "SUPERHEROS-db").build()
    }

    fun getDataBase(): TaskDatabase{
        return database
    }
}