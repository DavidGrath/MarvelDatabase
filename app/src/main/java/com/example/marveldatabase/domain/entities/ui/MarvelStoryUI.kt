package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.domain.entities.network.MarvelObjectImage
import com.example.marveldatabase.utils.Constants

data class MarvelStoryUI(
    val id: Int?,
    val title: String?,
    val description: String?,
    val resourceURI: String?,
    val type: String?,
    val modified: String?,
    val thumbnail: MarvelObjectImage?,
    val comics: MarvelUIResourceList<MarvelComicUISummary>?,
    val series: MarvelUIResourceList<MarvelSeriesUISummary>?,
    val events: MarvelUIResourceList<MarvelEventUISummary>?,
    val characters: MarvelUIResourceList<MarvelCharacterUISummary>?,
    val creators: MarvelUIResourceList<MarvelCreatorUISummary>?,
    val originalIssue: MarvelComicUISummary?
) : MarvelUIEntity {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_STORY
    }
}