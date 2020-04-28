package com.strivere.gamepedia

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GamepediaApi {

    @GET("/show_content.php")
    suspend fun getContent(): Response<List<ContentItem>>

    companion object{
        operator fun invoke() : GamepediaApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://gomangrove.com/backend_gamepedia")
                .build()
                .create(GamepediaApi::class.java)
        }
    }
}