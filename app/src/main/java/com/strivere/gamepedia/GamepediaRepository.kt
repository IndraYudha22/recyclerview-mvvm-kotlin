package com.strivere.gamepedia

class GamepediaRepository (private val api: GamepediaApi) : SafeApiRequest(){
    suspend fun getContent() = apiRequest { api.getContent() }
}