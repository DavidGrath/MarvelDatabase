package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarvelComic(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("digitalId")
    val digitalId: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("issueNumber")
    val issueNumber: Int?,
    @SerializedName("variantDescription")
    val variantDescription: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: Date?,
    @SerializedName("isbn")
    val isbn: String?,
    @SerializedName("upc")
    val upc: String?,
    @SerializedName("diamondCode")
    val diamondCode: String?,
    @SerializedName("ean")
    val ean: String?,
    @SerializedName("issn")
    val issn: String?,
    @SerializedName("format")
    val format: String?,
    @SerializedName("pageCount")
    val pageCount: Int?,
    @SerializedName("textObjects")
    val textObjects: List<MarvelObjectText>?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("urls")
    val urls: List<MarvelObjectUrl>?,
    @SerializedName("series")
    val series: MarvelSeriesSummary?,
    @SerializedName("variants")
    val variants: List<MarvelComicSummary>?,
    @SerializedName("collections")
    val collections: List<MarvelComicSummary>?,
    @SerializedName("collectedIssues")
    val collectedIssues: List<MarvelComicSummary>?,
    @SerializedName("dates")
    val dates: List<MarvelComicDate>?,
    @SerializedName("prices")
    val prices: List<MarvelComicPrice>?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelObjectImage?,
    @SerializedName("images")
    val images: List<MarvelObjectImage>?,
    @SerializedName("creators")
    val creators: MarvelResourceList<MarvelCreatorSummary>?,
    @SerializedName("characters")
    val characters: MarvelResourceList<MarvelCharacterSummary>?,
    @SerializedName("stories")
    val stories: MarvelResourceList<MarvelStorySummary>?,
    @SerializedName("events")
    val events: MarvelResourceList<MarvelEventSummary>?
) : MarvelEntity {
}