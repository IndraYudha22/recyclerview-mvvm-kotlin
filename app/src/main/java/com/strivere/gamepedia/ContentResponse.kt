package com.strivere.gamepedia

data class ContentResponse(
    val content: List<Content>,
    val status: Boolean
)