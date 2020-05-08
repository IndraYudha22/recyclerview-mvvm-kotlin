package com.strivere.gamepedia.data.network

import com.strivere.gamepedia.data.models.Game
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamepediaApi {

    @GET("show_content.php?id=all")
    suspend fun getContent() : Response<List<Game>>
//
    @GET("show_content.php")
    suspend fun getIdContent(@Query("id") idContent : String): Response<List<Game>>

    companion object{
        operator fun invoke() : GamepediaApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://testapidev.000webhostapp.com/apitest/")
                .build()
                .create(GamepediaApi::class.java)
        }
    }
}