package com.strivere.gamepedia.data.repositories

import com.strivere.gamepedia.data.network.GamepediaApi

class GamepediaRepository (
    private val api: GamepediaApi
) : SafeApiRequest(){
    suspend fun getContent() = apiRequest { api.getContent() }
    suspend fun getContentId(id: String) = apiRequest { api.getIdContent(id) }
}