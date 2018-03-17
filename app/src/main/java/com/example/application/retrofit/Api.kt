package com.example.application.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("marvel")
    fun getHeroes(): Call<List<Hero>>
}