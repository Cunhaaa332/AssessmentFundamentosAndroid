package com.cunha.assessment_gabriel_cunha_fundamentos.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cunha.assessment_gabriel_cunha_fundamentos.MainViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.R
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

        mainViewModel =
            ViewModelProvider (requireActivity()).get(MainViewModel::class.java)

        mainViewModel.music.observe(viewLifecycleOwner){
            if (it != null ) {
                textViewMusicName.text = it.NameMusic
                textViewMusicAlbum.text = it.NameAlbum
                textViewMusicArtist.text = it.NameArtist
                textViewMusicLink.text = it.Link
            } else{
                Snackbar.make(
                    frameLayoutDetailsMusic,
                    "Nenhuma Musica foi selecionada",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        return view
    }

}