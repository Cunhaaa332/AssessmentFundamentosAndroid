package com.cunha.assessment_gabriel_cunha_fundamentos.database

import com.cunha.assessment_gabriel_cunha_fundamentos.model.Music

class AppDatabase{

    private var musics : MutableList<Music> = mutableListOf(
        Music("I Write Sins Not Tragedies", "Panic! At the Disco", "A Fever You Can't Sweat Out", "aa", "https://www.youtube.com/watch?v=vc6vs-l5dkc"),
        Music("The Ghost Of You", "My Chemical Romance", "Three Cheers for Sweet Revenge", "aaa", "https://www.youtube.com/watch?v=uCUpvTMis-Y"),
        Music("Tears Dint Fall", "Bullet For My Valentine", "The Poison", "aa", "https://www.youtube.com/watch?v=9sTQ0QdkN3Q")
    )

    fun allMusics(): List<Music>{
        return musics
    }

    companion object{
        private var instance: AppDatabase? = null
        fun getInstance(): AppDatabase{
            if (instance == null)
                instance = AppDatabase()
            return instance as AppDatabase
        }
    }
}