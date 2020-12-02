package com.cunha.assessment_gabriel_cunha_fundamentos.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music

class AddMusicViewModel(var instance: AppDatabase ) : ViewModel() {
    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean>
        get() = _status

    init {
        _status.value = false
        _message.value = null
    }

    fun add(
        NameMusic : String,
        NameArtist : String,
        NameAlbum : String,
        Link : String
    ){
        instance.add(Music(
            NameMusic, NameArtist, NameAlbum, Link
        ))

        if(true){
            _status.value = true
            _message.value = "Cadastro realizado sem problemas!"
        }
    }
}