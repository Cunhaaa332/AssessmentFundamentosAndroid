package com.cunha.assessment_gabriel_cunha_fundamentos.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music

class ListMusicViewModel(appDatabase: AppDatabase) : ViewModel() {
    private val _musics = MutableLiveData<List<Music>>()
    val musics: LiveData<List<Music>>
    get() = _musics

    init {
        _musics.value = appDatabase.allMusics()
    }
}