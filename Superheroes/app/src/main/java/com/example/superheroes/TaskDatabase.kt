package com.example.superheroes

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.superheroes.converter.Converters
import com.example.superheroes.interfaces.TaskDao

@Database(entities = [Superhero::class],version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TaskDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao
}