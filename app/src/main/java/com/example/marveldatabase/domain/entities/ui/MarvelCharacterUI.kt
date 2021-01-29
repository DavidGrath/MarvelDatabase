package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.domain.entities.network.MarvelObjectImage
import com.example.marveldatabase.domain.entities.network.MarvelObjectUrl
import com.example.marveldatabase.utils.Constants
import java.util.*

data class MarvelCharacterUI(
    val id: Int?,
    val name: String?,
    val description: String?,
    val modified: Date?,
    val resourceURI: String?,
    //For this entity, and the other 5, I'm considering creating separate Url and Image
    // classes for this package
    val urls: List<MarvelObjectUrl>?,
    val thumbnail: MarvelObjectImage?,
    val comics: MarvelUIResourceList<MarvelComicUISummary>?,
    val stories: MarvelUIResourceList<MarvelStoryUISummary>?,
    val events: MarvelUIResourceList<MarvelEventUISummary>?,
    val series: MarvelUIResourceList<MarvelSeriesUISummary>?
) : MarvelUIEntity {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_CHARACTER
    }
}