package com.cunha.assessment_gabriel_cunha_fundamentos.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.ListMusicViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.R
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.ListMusicViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.list_music_fragment.*

class ListMusicFragment : Fragment() {

    private lateinit var listMusicViewModel: ListMusicViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_music_fragment, container, false)

        listMusicViewModel = ViewModelProvider(this, ListMusicViewModelFactory(AppDatabase.getInstance())).get(ListMusicViewModel::class.java)
        listMusicViewModel.musics.observe(viewLifecycleOwner){
            if(!it.isNullOrEmpty())
            listViewMusic.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
            else
                Snackbar.make(frameLayoutListMusic,
                "Nenhuma musica cadastrada na base.",
                Snackbar.LENGTH_LONG).show()
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}