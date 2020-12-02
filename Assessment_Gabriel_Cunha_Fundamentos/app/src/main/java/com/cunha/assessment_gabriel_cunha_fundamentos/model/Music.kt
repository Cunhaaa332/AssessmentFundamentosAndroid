package com.cunha.assessment_gabriel_cunha_fundamentos.model

class Music (
    var NameMusic : String,
    var NameArtist : String,
    var NameAlbum : String,
    var Photo : String,
    var Link : String
) {

    override fun toString(): String {
        return "$NameMusic by: $NameArtist"
    }

}