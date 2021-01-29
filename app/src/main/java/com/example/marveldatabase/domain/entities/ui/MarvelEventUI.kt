package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.domain.entities.network.MarvelObjectImage
import com.example.marveldatabase.domain.entities.network.MarvelObjectUrl
import com.example.marveldatabase.utils.Constants
import java.util.*

data class MarvelEventUI(
    val id: Int?,
    val title: String?,
    val description: String?,
    val resourceURI: String?,
    val urls: List<MarvelObjectUrl>?,
    val modified: Date?,
    val start: Date?,
    val end: Date?,
    val thumbnail: MarvelObjectImage?,
    val comics: MarvelUIResourceList<MarvelComicUISummary>?,
    val stories: MarvelUIResourceList<MarvelStoryUISummary>?,
    val series: MarvelUIResourceList<MarvelSeriesUISummary>?,
    val characters: MarvelUIResourceList<MarvelCharacterUISummary>?,
    val creators: MarvelUIResourceList<MarvelCreatorUISummary>?,
    val next: MarvelEventUISummary?,
    val previous: MarvelEventUISummary?
) : MarvelUIEntity {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_EVENT
    }
}