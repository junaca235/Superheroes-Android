package com.example.superheroes.interfaces

import com.example.superheroes.SuperheroResponse
import com.example.superheroes.Superheros
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getSuperherosbyId(@Url url: String): Response<Superheros>
}