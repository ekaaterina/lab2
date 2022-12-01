package com.example.test.network


import retrofit2.Call
import retrofit2.http.GET

interface ApiMarvel {

    @GET("characters?limit=10&apikey=48bf69d2a192ea2c177fb49ee195c7e9&ts=1&hash=0375f4f83dab712192fa2f367e23a8d4")
    fun getAllCharacters(): Call<Result>

    companion object{
        const val API_URL = "https://gateway.marvel.com:443/v1/public/"
    }
}
