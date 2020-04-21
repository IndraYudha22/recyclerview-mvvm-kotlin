package com.strivere.gamepedia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GamepediaViewModelFactory (private val repository: GamepediaRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}