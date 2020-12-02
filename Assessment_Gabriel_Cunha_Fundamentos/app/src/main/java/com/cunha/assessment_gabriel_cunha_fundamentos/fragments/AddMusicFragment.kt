package com.cunha.assessment_gabriel_cunha_fundamentos.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cunha.assessment_gabriel_cunha_fundamentos.R
import com.cunha.assessment_gabriel_cunha_fundamentos.database.AppDatabase
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.AddMusicViewModel
import com.cunha.assessment_gabriel_cunha_fundamentos.viewModel.AddMusicViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.add_music_fragment.*

class AddMusicFragment : Fragment() {

    private lateinit var addMusicViewModel: AddMusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.add_music_fragment, container, false)
        addMusicViewModel = ViewModelProvider(this, AddMusicViewModelFactory(AppDatabase.getInstance())).get(AddMusicViewModel::class.java)

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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnEnviar.setOnClickListener{
            addMusicViewModel.add(
                inputTextMusicName.text.toString(),
                inputTextArtistName.text.toString(),
                inputTextAlbumName.text.toString(),
                inputTextLink.text.toString()
            )
        }
    }

}