package com.cunha.assessment_gabriel_cunha_fundamentos.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import java.lang.IllegalArgumentException

class AddMusicViewModelFactory(var instance: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddMusicViewModel::class.java))
            return AddMusicViewModel(instance) as T
        throw  IllegalArgumentException("Illegal Argument")
    }

}
