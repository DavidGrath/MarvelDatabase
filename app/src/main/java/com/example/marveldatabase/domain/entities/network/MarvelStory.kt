package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelStory(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelObjectImage?,
    @SerializedName("comics")
    val comics: MarvelResourceList<MarvelComicSummary>?,
    @SerializedName("series")
    val series: MarvelResourceList<MarvelSeriesSummary>?,
    @SerializedName("events")
    val events: MarvelResourceList<MarvelEventSummary>?,
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelCharacterSummary>?,
    @SerializedName("creators")
    val creators: MarvelResourceList<MarvelCreatorSummary>?,
    @SerializedName("originalIssue")
    val originalIssue: MarvelComicSummary?
) : MarvelEntity {
}