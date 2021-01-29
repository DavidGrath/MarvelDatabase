package com.example.marveldatabase.data.entities

import java.util.*

data class MarvelCharacterData(
    val id: Int,
    val name: String,
    val description: String,
    val modified: Date,
    val resourceURI: String
) {
}