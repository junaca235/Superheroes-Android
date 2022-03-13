package com.example.superheroes.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superheroes.Superhero
import com.example.superheroes.SuperheroResponse
import com.example.superheroes.Superheros
@Dao
interface TaskDao {

    @Query("Select * from RESULT  where name = :n")
    fun getSuperhero(n: String): List<Superhero>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSuperhero(superhero: Superhero)

}