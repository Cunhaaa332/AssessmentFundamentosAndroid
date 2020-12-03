package com.cunha.assessment_gabriel_cunha_fundamentos.fragments

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
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.AddMusicViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.add_music_fragment.*

class AddMusicFragment : Fragment() {

    private lateinit var addMusicViewModel: AddMusicViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.add_music_fragment, container, false)
        addMusicViewModel = ViewModelProvider(this, ViewModelFactory(AppDatabase.getInstance())).get(AddMusicViewModel::class.java)

        addMusicViewModel.let {
            it.status.observe(viewLifecycleOwner){
                if(it) {
                    findNavController().popBackStack()
                }
            }
            it.message.observe(viewLifecycleOwner){
                if(!it.isNullOrBlank()) {
                    Snackbar.make(frameLayoutAddMusic, it, Snackbar.LENGTH_LONG).show()
                }
            }
        }

        mainViewModel =  ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        mainViewModel.music.observe(viewLifecycleOwner){
            if(it != null) {
                inputTextMusicName.setText(it.NameMusic)
                inputTextArtistName.setText(it.NameArtist)
                inputTextAlbumName.setText(it.NameAlbum)
                inputTextLink.setText(it.Link)
                inputTextNota.setText(it.Nota.toString())
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnEnviar.setOnClickListener{
            addMusicViewModel.add(
                inputTextMusicName.text.toString(),
                inputTextArtistName.text.toString(),
                inputTextAlbumName.text.toString(),
                inputTextLink.text.toString(),
                inputTextNota.text.toString().toInt(),
                mainViewModel.music.value
            )
        }
    }

}