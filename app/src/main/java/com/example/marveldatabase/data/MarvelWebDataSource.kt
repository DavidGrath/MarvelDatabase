package com.example.marveldatabase.data

import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.utils.CommaSepList
import java.util.*

interface MarvelWebDataSource {

    suspend fun getCharacters(
        name: String? = null, nameStartsWith: String? = null, modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null, seriesId: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null, stories: CommaSepList<Int>? = null,
        orderBy: String? = null, limit: Int? = null, offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    suspend fun getCharacter(characterId: Int): MarvelObjectWrapper<MarvelCharacter>

    suspend fun getCharacterFromUrl(url: String): MarvelObjectWrapper<MarvelCharacter>

    suspend fun getCharacterComics(
        characterId: Int,
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: CommaSepList<String>? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        sharedAppearances: CommaSepList<Int>? = null,
        collaborators: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    suspend fun getCharacterEvents(
        characterId: Int, name: String? = null, nameStartsWith: String? = null,
        modifiedSince: Date? = null, creators: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null, comics: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null, orderBy: String? = null,
        limit: Int? = null, offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    suspend fun getCharacterSeries(
        characterId: Int, title: String? = null, titleStartsWith: String? = null,
        startYear: String? = null, modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null, stories: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null, creators: CommaSepList<Int>? = null,
        seriesType: String? = null, contains: String? = null,
        orderBy: String? = null, limit: Int? = null, offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    suspend fun getCharacterStories(
        characterId: Int, modifiedSince: Date? = null, comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null, events: CommaSepList<Int>? = null,
        creators: CommaSepList<Int>? = null, orderBy: String? = null, limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    suspend fun getComics(
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: CommaSepList<String>? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        sharedAppearances: CommaSepList<Int>? = null,
        collaborators: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    suspend fun getComic(comicId: Int): MarvelObjectWrapper<MarvelComic>

    suspend fun getComicFromUrl(url: String): MarvelObjectWrapper<MarvelComic>

    suspend fun getComicCharacters(
        comicId: Int, title: String? = null, titleStartsWith: String? = null,
        modifiedSince: Date? = null, comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null, events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null, orderBy: String? = null,
        limit: Int? = null, offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    suspend fun getComicCreators(
        comicId: Int, firstName: String? = null, middleName: String? = null,
        lastName: String? = null, suffix: String? = null, nameStartsWith: String? = null,
        firstNameStartsWith: String? = null, middleNameStartsWith: String? = null,
        lastNameStartsWith: String? = null, modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null, series: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null, orderBy: String? = null, limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    suspend fun getComicEvents(
        comicId: Int, title: String? = null, titleStartsWith: String? = null,
        modifiedSince: Date? = null, creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null, series: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null, orderBy: String? = null,
        limit: Int? = null, offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    suspend fun getComicStories(
        comicId: Int, modifiedSince: Date? = null, series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null, creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null, orderBy: String? = null, limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    suspend fun getCreators(
        firstName: String? = null, middleName: String? = null, lastName: String? = null,
        suffix: String? = null, nameStartsWith: String? = null, firstNameStartsWith: String? = null,
        middleNameStartsWith: String? = null, lastNameStartsWith: String? = null,
        modifiedSince: Date? = null, comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null, events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null, orderBy: String? = null, limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    suspend fun getCreator(creatorId: Int): MarvelObjectWrapper<MarvelCreator>

    suspend fun getCreatorFromUrl(url: String): MarvelObjectWrapper<MarvelCreator>

    suspend fun getCreatorComics(
        creatorId: Int,
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: CommaSepList<String>? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        sharedAppearances: CommaSepList<Int>? = null,
        collaborators: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    suspend fun getCreatorEvents(
        creatorId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        modifiedSince: Date? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        comics: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    suspend fun getCreatorSeries(
        creatorId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        seriesType: String? = null,
        contains: String? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    suspend fun getCreatorStories(
        creatorId: Int,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    suspend fun getEvents(
        title: String? = null,
        titleStartsWith: String? = null,
        modifiedSince: Date? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        comics: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    suspend fun getEvent(eventId: Int): MarvelObjectWrapper<MarvelEvent>

    suspend fun getEventFromUrl(url: String): MarvelObjectWrapper<MarvelEvent>

    suspend fun getEventCharacters(
        eventId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    suspend fun getEventComics(
        eventId: Int,
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: CommaSepList<String>? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        sharedAppearances: CommaSepList<Int>? = null,
        collaborators: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    suspend fun getEventCreators(
        eventId: Int,
        firstName: String? = null,
        middleName: String? = null,
        lastName: String? = null,
        suffix: String? = null,
        nameStartsWith: String? = null,
        firstNameStartsWith: String? = null,
        middleNameStartsWith: String? = null,
        lastNameStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    suspend fun getEventSeries(
        eventId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        seriesType: String? = null,
        contains: String? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    suspend fun getEventStories(
        eventId: Int,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    suspend fun getSeriesPlural(
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        seriesType: String? = null,
        contains: String? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>

    suspend fun getSeriesSingular(seriesId: Int): MarvelObjectWrapper<MarvelSeries>

    suspend fun getSeriesSingularFromUrl(url: String): MarvelObjectWrapper<MarvelSeries>

    suspend fun getSeriesSingularCharacters(
        seriesId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    suspend fun getSeriesSingularComics(
        seriesId: Int,
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: CommaSepList<String>? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        sharedAppearances: CommaSepList<Int>? = null,
        collaborators: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    suspend fun getSeriesSingularCreators(
        seriesId: Int,
        firstName: String? = null,
        middleName: String? = null,
        lastName: String? = null,
        suffix: String? = null,
        nameStartsWith: String? = null,
        firstNameStartsWith: String? = null,
        middleNameStartsWith: String? = null,
        lastNameStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    suspend fun getSeriesSingularEvents(
        seriesId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        comics: CommaSepList<Int>? = null,
        stories: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    suspend fun getSeriesSingularStories(
        seriesId: Int,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>


    suspend fun getStories(
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelStory>

    suspend fun getStory(storyId: Int): MarvelObjectWrapper<MarvelStory>

    suspend fun getStoryFromUrl(url: String): MarvelObjectWrapper<MarvelStory>

    suspend fun getStoryCharacters(
        storyId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelCharacter>

    suspend fun getStoryComics(
        storyId: Int,
        format: String? = null,
        formatType: String? = null,
        noVariants: Boolean? = null,
        dateDescriptor: String? = null,
        dateRange: CommaSepList<String>? = null,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: Int? = null,
        issueNumber: Int? = null,
        diamondCode: String? = null,
        digitalId: Int? = null,
        upc: String? = null,
        isbn: String? = null,
        ean: String? = null,
        issn: String? = null,
        hasDigitalIssue: Boolean? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        sharedAppearances: CommaSepList<Int>? = null,
        collaborators: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelComic>

    suspend fun getStoryCreators(
        storyId: Int,
        firstName: String? = null,
        middleName: String? = null,
        lastName: String? = null,
        suffix: String? = null,
        nameStartsWith: String? = null,
        firstNameStartsWith: String? = null,
        middleNameStartsWith: String? = null,
        lastNameStartsWith: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelCreator>

    suspend fun getStoryEvents(
        storyId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        modifiedSince: Date? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        series: CommaSepList<Int>? = null,
        comics: CommaSepList<Int>? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelEvent>

    suspend fun getStorySeries(
        storyId: Int,
        title: String? = null,
        titleStartsWith: String? = null,
        startYear: String? = null,
        modifiedSince: Date? = null,
        comics: CommaSepList<Int>? = null,
        creators: CommaSepList<Int>? = null,
        characters: CommaSepList<Int>? = null,
        events: CommaSepList<Int>? = null,
        seriesType: String? = null,
        contains: String? = null,
        orderBy: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): MarvelObjectWrapper<MarvelSeries>
}