package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.utils.Constants

data class MarvelComicUISummary(
    val resourceURI: String?,
    val name: String?
) : MarvelUISummary {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_COMIC
    }
}