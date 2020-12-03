package com.cunha.assessment_gabriel_cunha_fundamentos.model

class Music (
    var NameMusic : String,
    var NameArtist : String,
    var NameAlbum : String,
    var Link : String,
    var Nota: Int
) {

    override fun toString(): String {
        return "$NameMusic by: $NameArtist"
    }

}