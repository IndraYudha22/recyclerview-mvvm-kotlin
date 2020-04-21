package com.strivere.gamepedia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: GamepediaRepository) : ViewModel() {
    private val _content = MutableLiveData<List<Content>>()
    val content : LiveData<List<Content>> get() = _content

    suspend fun getContent(){
        val content = repository.getContent()
        _content.value = content
    }
}
