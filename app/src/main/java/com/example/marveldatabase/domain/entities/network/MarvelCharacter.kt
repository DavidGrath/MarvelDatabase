package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarvelCharacter(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: Date?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("urls")
    val urls: List<MarvelObjectUrl>?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelObjectImage?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelComicSummary>?,
    @SerializedName("stories")
    val stories: MarvelResourceList<MarvelStorySummary>?,
    @SerializedName("events")
    val events: MarvelResourceList<MarvelEventSummary>?,
    @SerializedName("series")
    val series: MarvelResourceList<MarvelSeriesSummary>?
) : MarvelEntity {
}