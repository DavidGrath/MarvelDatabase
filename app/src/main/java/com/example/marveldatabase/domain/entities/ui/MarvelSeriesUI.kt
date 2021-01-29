package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.domain.entities.network.MarvelObjectImage
import com.example.marveldatabase.domain.entities.network.MarvelObjectUrl
import com.example.marveldatabase.utils.Constants
import java.util.*

data class MarvelSeriesUI(
    val id: Int?,
    val title: String?,
    val description: String?,
    val resourceURI: String?,
    val urls: List<MarvelObjectUrl>?,
    val startDate: Int?,
    val endDate: Int?,
    val rating: String?,
    val modified: Date?,
    val thumbnail: MarvelObjectImage?,
    val comics: MarvelUIResourceList<MarvelComicUISummary>?,
    val stories: MarvelUIResourceList<MarvelStoryUISummary>?,
    val events: MarvelUIResourceList<MarvelEventUISummary>?,
    val characters: MarvelUIResourceList<MarvelCharacterUISummary>?,
    val creators: MarvelUIResourceList<MarvelCreatorUISummary>?,
    val next: MarvelSeriesUISummary?,
    val previous: MarvelSeriesUISummary?
) : MarvelUIEntity {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_SERIES
    }
}