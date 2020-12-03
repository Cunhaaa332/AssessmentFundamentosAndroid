package com.cunha.assessment_gabriel_cunha_fundamentos.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music

class DetailsMusicViewModel(var appDatabase: AppDatabase) : ViewModel() {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean>
        get() = _status

    init{
        _status.value = false
        _message.value = null
    }

    fun delete(music: Music) {
        _message.value = "Doing music delete."
        appDatabase.delete(music)
        _message.value = "Delete complete."
        _status.value = true
    }
}