package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.utils.Constants

data class MarvelStoryUISummary(
    val resourceURI: String?,
    val name: String?,
    val type: String?
) : MarvelUISummary {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_STORY
    }
}