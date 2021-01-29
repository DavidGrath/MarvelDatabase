package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarvelCreator(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("middleName")
    val middleName: String?,
    @SerializedName("suffix")
    val suffix: String?,
    @SerializedName("fullName")
    val fullName: String?,
    @SerializedName("modified")
    val modified: Date?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("urls")
    val urls: List<MarvelObjectUrl>?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelObjectImage?,
    @SerializedName("series")
    val series: MarvelResourceList<MarvelSeriesSummary>?,
    @SerializedName("stories")
    val stories: MarvelResourceList<MarvelStorySummary>?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelComicSummary>?,
    @SerializedName("events")
    val events: MarvelResourceList<MarvelEventSummary>?
) : MarvelEntity {
}