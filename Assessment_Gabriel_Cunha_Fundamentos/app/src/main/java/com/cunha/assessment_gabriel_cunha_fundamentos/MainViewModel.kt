package com.cunha.assessment_gabriel_cunha_fundamentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music

class MainViewModel : ViewModel() {

    private val _music = MutableLiveData<Music>()
    val music: LiveData<Music>
    get() = _music

    fun selectMusic(music: Music){
        _music.value = music
    }
}