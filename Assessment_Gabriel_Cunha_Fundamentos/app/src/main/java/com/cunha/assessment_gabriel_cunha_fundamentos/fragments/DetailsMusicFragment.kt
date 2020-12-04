package com.cunha.assessment_gabriel_cunha_fundamentos.fragments

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cunha.assessment_gabriel_cunha_fundamentos.MainViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.R
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.factory.ViewModelFactory
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.DetailsMusicViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.details_music_fragment.*

class detailsMusicFragment : Fragment() {


    private lateinit var detailsMusicViewModel: DetailsMusicViewModel
    private lateinit var  mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.details_music_fragment, container, false)

        detailsMusicViewModel = ViewModelProvider(this, ViewModelFactory(AppDatabase.getInstance())).get(DetailsMusicViewModel::class.java)

        mainViewModel = ViewModelProvider (requireActivity()).get(MainViewModel::class.java)

        mainViewModel.music.observe(viewLifecycleOwner){
            if (it != null ) {
                textViewMusicName.text = it.NameMusic
                textViewMusicAlbum.text = it.NameAlbum
                textViewMusicArtist.text = it.NameArtist
                textViewNota.text = it.Nota.toString()
            } else if (!detailsMusicViewModel.status.value!!) {
                Snackbar.make(
                    frameLayoutDetailsMusic,
                    "Nenhuma Musica foi selecionada",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        detailsMusicViewModel.message.observe(viewLifecycleOwner){
            if(!it.isNullOrBlank()) {
                Snackbar.make(
                        frameLayoutDetailsMusic,
                        it,
                        Snackbar.LENGTH_LONG
                ).show()
            }
        }

        detailsMusicViewModel.status.observe(viewLifecycleOwner){
            if(it){
                mainViewModel.deleteMusic()
                findNavController().popBackStack()
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDelete.setOnClickListener{
            var music = mainViewModel.music.value
            detailsMusicViewModel.delete(music!!)
        }

        btnEdit.setOnClickListener{
            findNavController().navigate(R.id.addMusicFragment)
        }


    }

}