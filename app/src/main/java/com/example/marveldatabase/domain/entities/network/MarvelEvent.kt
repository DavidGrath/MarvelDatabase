package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarvelEvent(
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
    @SerializedName("modified")
    val modified: Date?,
    @SerializedName("start")
    val start: Date?,
    @SerializedName("end")
    val end: Date?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelObjectImage?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelComicSummary>?,
    @SerializedName("stories")
    val stories: MarvelResourceList<MarvelStorySummary>?,
    @SerializedName("series")
    val series: MarvelResourceList<MarvelSeriesSummary>?,
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelCharacterSummary>?,
    @SerializedName("creators")
    val creators: MarvelResourceList<MarvelCreatorSummary>?,
    @SerializedName("next")
    val next: MarvelEventSummary?,
    @SerializedName("previous")
    val previous: MarvelEventSummary?
) : MarvelEntity {
}