package com.cunha.assessment_gabriel_cunha_fundamentos.database

import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music

class AppDatabase{

    private var musics : MutableList<Music> = mutableListOf(
        Music("I Write Sins Not Tragedies", "Panic! At the Disco", "A Fever You Can't Sweat Out", "https://www.youtube.com/watch?v=vc6vs-l5dkc", 8),
        Music("The Ghost Of You", "My Chemical Romance", "Three Cheers for Sweet Revenge", "https://www.youtube.com/watch?v=uCUpvTMis-Y", 10),
        Music("Tears Don't Fall", "Bullet For My Valentine", "The Poison", "https://www.youtube.com/watch?v=9sTQ0QdkN3Q", 9)
    )

    fun allMusics(): List<Music>{
        return musics
    }

    fun add(music: Music) {
        musics.add(music)
    }

    fun delete(music: Music) {
        musics.remove(music)
    }

    fun edit(nameMusic: String, nameArtist: String, nameAlbum: String, link: String, nota: Int, music: Music) {
        var index = musics.indexOf(music)
        music.NameMusic = nameMusic
        music.NameArtist = nameArtist
        music.NameAlbum = nameAlbum
        music.Link = link
        music.Nota = nota
        musics[index] = music
    }


    companion object{
        private var instance: AppDatabase? = null
        fun getInstance(): AppDatabase{
            if (instance == null) {
                instance = AppDatabase()
            }
            return instance as AppDatabase
        }
    }
}