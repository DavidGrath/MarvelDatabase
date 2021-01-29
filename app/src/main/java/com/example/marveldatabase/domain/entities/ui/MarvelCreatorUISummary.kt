package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.utils.Constants

data class MarvelCreatorUISummary(
    val resourceURI: String?,
    val name: String?,
    val role: String?
) : MarvelUISummary {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_CREATOR
    }
}