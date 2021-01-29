package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.domain.entities.network.MarvelObjectImage
import com.example.marveldatabase.domain.entities.network.MarvelObjectUrl
import com.example.marveldatabase.utils.Constants
import java.util.*

data class MarvelCreatorUI(
    val id: Int?,
    val firstName: String?,
    val lastName: String?,
    val middleName: String?,
    val suffix: String?,
    val fullName: String?,
    val modified: Date?,
    val resourceURI: String?,
    val urls: List<MarvelObjectUrl>?,
    val thumbnail: MarvelObjectImage?,
    val series: MarvelUIResourceList<MarvelSeriesUISummary>?,
    val stories: MarvelUIResourceList<MarvelStoryUISummary>?,
    val comics: MarvelUIResourceList<MarvelComicUISummary>?,
    val events: MarvelUIResourceList<MarvelEventUISummary>?
) : MarvelUIEntity {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_CREATOR
    }
}