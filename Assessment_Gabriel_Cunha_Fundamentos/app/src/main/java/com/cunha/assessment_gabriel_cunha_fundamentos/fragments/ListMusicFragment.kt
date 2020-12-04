package com.cunha.assessment_gabriel_cunha_fundamentos.fragments

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cunha.assessment_gabriel_cunha_fundamentos.MainViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.ListMusicViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.R
import com.cunha.assessment_gabriel_cunha_fundamentos.adapter.MusicRecyclerAdapter
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.factory.ViewModelFactory
import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.list_music_fragment.*

class ListMusicFragment : Fragment() {

    private lateinit var listMusicViewModel: ListMusicViewModel
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_music_fragment, container, false)

        listMusicViewModel = ViewModelProvider(this, ViewModelFactory(AppDatabase.getInstance())).get(ListMusicViewModel::class.java)
        listMusicViewModel.musics.observe(viewLifecycleOwner){
            if(!it.isNullOrEmpty()) {
                val musicRecyclerAdapter = MusicRecyclerAdapter(it, this::actionClickMusicLink, this::actionClickMusicVerMais)
                listViewMusic.adapter = musicRecyclerAdapter
                listViewMusic.layoutManager = LinearLayoutManager(requireContext())
            }else {
                Snackbar.make(
                    frameLayoutListMusic,
                    "Nenhuma musica cadastrada na base.",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
        mainViewModel = ViewModelProvider(requireActivity())
            .get(MainViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButtonAddMusic.setOnClickListener{
            mainViewModel.selectMusic(null)
            findNavController().navigate(R.id.addMusicFragment)
        }
    }

    private fun actionClickMusicLink(music: Music){
        var intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(music?.Link)
        )
        startActivity(intent)
    }

    private fun actionClickMusicVerMais(music: Music){
        mainViewModel.selectMusic(music)
        findNavController().navigate(R.id.detailsMusicFragment)
    }
}