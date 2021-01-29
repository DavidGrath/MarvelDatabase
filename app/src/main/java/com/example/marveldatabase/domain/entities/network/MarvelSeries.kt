package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarvelSeries(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("urls")
    val urls: List<MarvelObjectUrl>?,
    @SerializedName("startDate")
    val startDate: Int?,
    @SerializedName("endDate")
    val endDate: Int?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("modified")
    val modified: Date?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelObjectImage?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelComicSummary>?,
    @SerializedName("stories")
    val stories: MarvelResourceList<MarvelStorySummary>?,
    @SerializedName("events")
    val events: MarvelResourceList<MarvelEventSummary>?,
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelCharacterSummary>?,
    @SerializedName("creators")
    val creators: MarvelResourceList<MarvelCreatorSummary>?,
    @SerializedName("next")
    val next: MarvelSeriesSummary?,
    @SerializedName("previous")
    val previous: MarvelSeriesSummary?
) : MarvelEntity {
}