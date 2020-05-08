package com.strivere.gamepedia.ui.menudetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import com.strivere.gamepedia.utils.Coroutines
import kotlinx.coroutines.Job

class DetailViewModel(private val repository: GamepediaRepository) : ViewModel() {
    private val _content = MutableLiveData<List<Game>>()
    val content : LiveData<List<Game>> get() = _content

    private  lateinit var job: Job

    fun getContentId(id: String){
        job = Coroutines.ioThenMain(
            { repository.getContentId(id) },
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
