package com.example.marveldatabase.domain.entities.ui

import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.utils.Constants
import java.util.*

data class MarvelComicUI(
    val id: Int?,
    val digitalId: Int?,
    val title: String?,
    val issueNumber: Int?,
    val variantDescription: String?,
    val description: String?,
    val modified: Date?,
    val isbn: String?,
    val upc: String?,
    val diamondCode: String?,
    val ean: String?,
    val issn: String?,
    val format: String?,
    val pageCount: Int?,
    val textObjects: List<MarvelObjectText>?,
    val resourceURI: String?,
    val urls: List<MarvelObjectUrl>?,
    val series: MarvelSeriesUISummary?,
    val variants: List<MarvelComicUISummary>?,
    val collections: List<MarvelComicUISummary>?,
    val collectedIssues: List<MarvelComicUISummary>?,
    val dates: List<MarvelComicDate>?,
    val prices: List<MarvelComicPrice>?,
    val thumbnail: MarvelObjectImage?,
    val images: List<MarvelObjectImage>?,
    val creators: MarvelUIResourceList<MarvelCreatorUISummary>?,
    val characters: MarvelUIResourceList<MarvelCharacterUISummary>?,
    val stories: MarvelUIResourceList<MarvelStoryUISummary>?,
    val events: MarvelUIResourceList<MarvelEventUISummary>?
) : MarvelUIEntity {
    override fun getType(): Int {
        return Constants.MARVEL_ENTITY_COMIC
    }
}