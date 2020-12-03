package com.cunha.assessment_gabriel_cunha_fundamentos.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.AddMusicViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.DetailsMusicViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.ListMusicViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(var appDatabase: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListMusicViewModel::class.java))
            return ListMusicViewModel(appDatabase) as T

        if(modelClass.isAssignableFrom(AddMusicViewModel::class.java))
            return AddMusicViewModel(appDatabase) as T

        if(modelClass.isAssignableFrom(DetailsMusicViewModel::class.java))
            return DetailsMusicViewModel(appDatabase) as T

        throw IllegalArgumentException("Illegal Argument")
    }
}