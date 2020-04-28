package com.strivere.gamepedia.ui.mainmenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.utils.Coroutines
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import kotlinx.coroutines.Job

class MainViewModel(private val repository: GamepediaRepository) : ViewModel() {
    private val _content = MutableLiveData<List<Game>>()
    val content : LiveData<List<Game>> get() = _content

    private  lateinit var job: Job

    fun getContent(){
        job = Coroutines.ioThenMain(
            { repository.getContent() },
            {
                _content.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
