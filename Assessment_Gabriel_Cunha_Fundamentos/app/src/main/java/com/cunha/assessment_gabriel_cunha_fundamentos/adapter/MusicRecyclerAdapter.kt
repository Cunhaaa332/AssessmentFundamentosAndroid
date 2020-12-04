package com.cunha.assessment_gabriel_cunha_fundamentos.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.cunha.assessment_gabriel_cunha_fundamentos.R
import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music
import kotlinx.android.synthetic.main.list_music_recycler.view.*

class MusicRecyclerAdapter(
        private val musics: List<Music>
): RecyclerView.Adapter<MusicRecyclerAdapter.MusicViewHolder>() {

    class MusicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewNomeMusic = itemView.textViewRecyclerNomeMusic
        val textViewNomeArtist = itemView.textViewRecyclerNomeArtist
        val textViewNota = itemView.textViewRecyclerNota
        //val btnMusicLink = itemView.btnRecyclerLink
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.list_music_recycler,
                        parent,
                        false
                )
        val  musicViewHolder = MusicViewHolder(view)
        return musicViewHolder
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = musics.get(position)
        var intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(music.Link)
        )
        holder.textViewNomeMusic.text = music.NameMusic
        holder.textViewNomeArtist.text = music.NameArtist
        holder.textViewNota.text = music.Nota.toString()
        //holder.btnMusicLink.setOnClickListener{
          //  startActivity(intent)
        //}
    }

    override fun getItemCount(): Int {
        return musics.size
    }
    
}