package com.strivere.gamepedia.ui.mainmenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import com.strivere.gamepedia.ui.menudetail.DetailViewModel

class GamepediaViewModelFactory (private val repository: GamepediaRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(repository) as T
        else if (modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(repository) as T
        throw IllegalArgumentException("View model tidak diketahui")
    }
}