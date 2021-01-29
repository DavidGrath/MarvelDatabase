package com.example.marveldatabase.framework

import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.utils.CommaSepList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import java.util.*

interface MarvelRetrofitClient {
    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("seriesId") seriesId: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    @GET("characters/{characterId}")
    suspend fun getCharacter(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("characterId") characterId: Int
    ): MarvelObjectWrapper<MarvelCharacter>

    @GET
    suspend fun getCharacterFromUrl(
        @Url url: String, @Query("apikey") apikey: String, @Query("ts") ts: String,
        @Query("hash") hash: String
    ): MarvelObjectWrapper<MarvelCharacter>

    @GET("characters/{characterId}/comics")
    suspend fun getCharacterComics(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("characterId") characterId: Int,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: CommaSepList<String>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: CommaSepList<Int>? = null,
        @Query("collaborators") collaborators: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    @GET("characters/{characterId}/events")
    suspend fun getCharacterEvents(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("characterId") characterId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("characters/{characterId}/series")
    suspend fun getCharacterSeries(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("characterId") characterId: Int,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: String? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    @GET("characters/{characterId}/stories")
    suspend fun getCharacterStories(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("characterId") characterId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    @GET("comics")
    suspend fun getComics(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: CommaSepList<String>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: CommaSepList<Int>? = null,
        @Query("collaborators") collaborators: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null

    ): MarvelObjectWrapper<MarvelComic>

    @GET("comics/{comicId}")
    suspend fun getComic(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("comicId") comicId: Int
    ): MarvelObjectWrapper<MarvelComic>

    @GET
    suspend fun getComicFromUrl(
        @Url url: String, @Query("apikey") apikey: String, @Query("ts") ts: String,
        @Query("hash") hash: String
    ): MarvelObjectWrapper<MarvelComic>

    @GET("comics/{comicId}/characters")
    suspend fun getComicCharacters(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("comicId") comicId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    @GET("comics/{comicId}/creators")
    suspend fun getComicCreators(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("comicId") comicId: Int,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    @GET("comics/{comicId}/events")
    suspend fun getComicEvents(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("comicId") comicId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("comics/{comicId}/events")
    suspend fun getComicStories(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("comicId") comicId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    @GET("creators")
    suspend fun getCreators(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    @GET("creators/{creatorId}")
    suspend fun getCreator(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("creatorId") creatorId: Int
    ): MarvelObjectWrapper<MarvelCreator>

    @GET
    suspend fun getCreatorFromUrl(
        @Url url: String, @Query("apikey") apikey: String, @Query("ts") ts: String,
        @Query("hash") hash: String
    ): MarvelObjectWrapper<MarvelCreator>

    @GET("creators/{creatorId}/comics")
    suspend fun getCreatorComics(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("creatorId") creatorId: Int,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: CommaSepList<String>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: CommaSepList<Int>? = null,
        @Query("collaborators") collaborators: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    @GET("creators/{creatorId}/events")
    suspend fun getCreatorEvents(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("creatorId") creatorId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("creators/{creatorId}/series")
    suspend fun getCreatorSeries(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("creatorId") creatorId: Int,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: String? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    @GET("creators/{creatorId}/stories")
    suspend fun getCreatorStories(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("creatorId") creatorId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    @GET("events")
    suspend fun getEvents(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("events/{eventId}")
    suspend fun getEvent(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("eventId") eventId: Int
    ): MarvelObjectWrapper<MarvelEvent>

    @GET
    suspend fun getEventFromUrl(
        @Url url: String, @Query("apikey") apikey: String, @Query("ts") ts: String,
        @Query("hash") hash: String
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("events/{eventId}/characters")
    suspend fun getEventCharacters(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("eventId") eventId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    @GET("events/{eventId}/comics")
    suspend fun getEventComics(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("eventId") eventId: Int,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: CommaSepList<String>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: CommaSepList<Int>? = null,
        @Query("collaborators") collaborators: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    @GET("events/{eventId}/creators")
    suspend fun getEventCreators(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("eventId") eventId: Int,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("events/{eventId}/series")
    suspend fun getEventSeries(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("eventId") eventId: Int,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: String? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    @GET("events/{eventId}/stories")
    suspend fun getEventStories(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("eventId") eventId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    @GET("series")
    suspend fun getSeriesPlural(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: String? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    @GET("series/{seriesId}")
    suspend fun getSeriesSingular(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("seriesId") seriesId: Int
    ): MarvelObjectWrapper<MarvelSeries>

    @GET
    suspend fun getSeriesSingularFromUrl(
        @Url url: String, @Query("apikey") apikey: String, @Query("ts") ts: String,
        @Query("hash") hash: String
    ): MarvelObjectWrapper<MarvelSeries>

    @GET("series/{seriesId}/characters")
    suspend fun getSeriesSingularCharacters(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("seriesId") seriesId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    @GET("series/{seriesId}/comics")
    suspend fun getSeriesSingularComics(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("seriesId") seriesId: Int,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: CommaSepList<String>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: CommaSepList<Int>? = null,
        @Query("collaborators") collaborators: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    @GET("series/{seriesId}/creators")
    suspend fun getSeriesSingularCreators(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("seriesId") seriesId: Int,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    @GET("series/{seriesId}/events")
    suspend fun getSeriesSingularEvents(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("seriesId") seriesId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("stories") stories: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("series/{seriesId}/stories")
    suspend fun getSeriesSingularStories(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("seriesId") seriesId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    @GET("stories")
    suspend fun getStories(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>

    @GET("stories/{storyId}")
    suspend fun getStory(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("storyId") storyId: Int
    ): MarvelObjectWrapper<MarvelStory>

    @GET
    suspend fun getStoryFromUrl(
        @Url url: String, @Query("apikey") apikey: String, @Query("ts") ts: String,
        @Query("hash") hash: String
    ): MarvelObjectWrapper<MarvelStory>

    @GET("stories/{storyId}/characters")
    suspend fun getStoryCharacters(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("storyId") storyId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    @GET("stories/{storyId}/comics")
    suspend fun getStoryComics(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("storyId") storyId: Int,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: CommaSepList<String>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: CommaSepList<Int>? = null,
        @Query("collaborators") collaborators: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    @GET("stories/{storyId}/creators")
    suspend fun getStoryCreators(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("storyId") storyId: Int,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    @GET("stories/{storyId}/events")
    suspend fun getStoryEvents(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("storyId") storyId: Int,
        @Query("name") title: String? = null,
        @Query("nameStartsWith") titleStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("series") series: CommaSepList<Int>? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    @GET("stories/{storyId}/series")
    suspend fun getStorySeries(
        @Query("apikey") apikey: String, @Query("ts") ts: String, @Query("hash") hash: String,
        @Path("storyId") storyId: Int,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: CommaSepList<Int>? = null,
        @Query("creators") creators: CommaSepList<Int>? = null,
        @Query("characters") characters: CommaSepList<Int>? = null,
        @Query("events") events: CommaSepList<Int>? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: String? = null,
        @Query("orderBy") orderBy: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>
}