package com.example.marveldatabase.framework

import com.example.marveldatabase.BuildConfig
import com.example.marveldatabase.data.MarvelWebDataSource
import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.utils.CommaSepList
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class MarvelWebDataSourceImpl(
    val retrofitClient: MarvelRetrofitClient
) : MarvelWebDataSource {

    val apikey: String
    val ts: String
    val hash: String

    init {
        apikey = BuildConfig.PUBLIC_API_KEY
        ts = Date().time.toString()
        val concat = ts + BuildConfig.PRIVATE_API_KEY + BuildConfig.PUBLIC_API_KEY
        val digest = MessageDigest.getInstance("MD5").digest(concat.toByteArray())
        val num = BigInteger(1, digest)
        var digestText = num.toString(16)
        while (digestText.length < 32) {
            digestText = "0" + digestText
        }
        hash = digestText
    }

    override suspend fun getCharacters(
        name: String?,
        nameStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        seriesId: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCharacter> {
        return retrofitClient.getCharacters(
            apikey, ts, hash, name, nameStartsWith, modifiedSince, comics, seriesId,
            events, stories, orderBy, limit, offset
        )
    }

    override suspend fun getCharacter(characterId: Int): MarvelObjectWrapper<MarvelCharacter> {
        return retrofitClient.getCharacter(apikey, ts, hash, characterId)
    }

    override suspend fun getCharacterFromUrl(url: String): MarvelObjectWrapper<MarvelCharacter> {
        return retrofitClient.getCharacterFromUrl(url, apikey, ts, hash)
    }

    override suspend fun getCharacterComics(
        characterId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: CommaSepList<String>?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        sharedAppearances: CommaSepList<Int>?,
        collaborators: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getCharacterComics(
            apikey,
            ts,
            hash,
            characterId,
            format,
            formatType,
            noVariants,
            dateDescriptor,
            dateRange,
            title,
            titleStartsWith,
            startYear,
            issueNumber,
            diamondCode,
            digitalId,
            upc,
            isbn,
            ean,
            issn,
            hasDigitalIssue,
            modifiedSince,
            creators,
            series,
            events,
            stories,
            sharedAppearances,
            collaborators,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getCharacterEvents(
        characterId: Int,
        name: String?,
        nameStartsWith: String?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getCharacterEvents(
            apikey, ts, hash, characterId, name, nameStartsWith, modifiedSince,
            creators, series, comics, stories, orderBy, limit, offset
        )
    }

    override suspend fun getCharacterSeries(
        characterId: Int,
        title: String?,
        titleStartsWith: String?,
        startYear: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        seriesType: String?,
        contains: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelSeries> {
        return retrofitClient.getCharacterSeries(
            apikey,
            ts,
            hash,
            characterId,
            title,
            titleStartsWith,
            startYear,
            modifiedSince,
            comics,
            stories,
            events,
            creators,
            seriesType,
            contains,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getCharacterStories(
        characterId: Int,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getCharacterStories(
            apikey, ts, hash, characterId, modifiedSince,
            comics, series, events, creators, orderBy, limit, offset
        )
    }

    override suspend fun getComics(
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: CommaSepList<String>?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        sharedAppearances: CommaSepList<Int>?,
        collaborators: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getComics(
            apikey,
            ts,
            hash,
            format,
            formatType,
            noVariants,
            dateDescriptor,
            dateRange,
            title,
            titleStartsWith,
            startYear,
            issueNumber,
            diamondCode,
            digitalId,
            upc,
            isbn,
            ean,
            issn,
            hasDigitalIssue,
            modifiedSince,
            creators,
            characters,
            series,
            events,
            stories,
            sharedAppearances,
            collaborators,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getComic(comicId: Int): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getComic(apikey, ts, hash, comicId)
    }

    override suspend fun getComicFromUrl(url: String): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getComicFromUrl(url, apikey, ts, hash)
    }

    override suspend fun getComicCharacters(
        comicId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCharacter> {
        return retrofitClient.getComicCharacters(
            apikey, ts, hash, comicId, title, titleStartsWith, modifiedSince,
            comics, series, events, stories, orderBy, limit, offset
        )
    }

    override suspend fun getComicCreators(
        comicId: Int,
        firstName: String?,
        middleName: String?,
        lastName: String?,
        suffix: String?,
        nameStartsWith: String?,
        firstNameStartsWith: String?,
        middleNameStartsWith: String?,
        lastNameStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCreator> {
        return retrofitClient.getComicCreators(
            apikey,
            ts,
            hash,
            comicId,
            firstName,
            middleName,
            lastName,
            suffix,
            nameStartsWith,
            firstNameStartsWith,
            middleNameStartsWith,
            lastNameStartsWith,
            modifiedSince,
            comics,
            series,
            stories,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getComicEvents(
        comicId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getComicEvents(
            apikey, ts, hash, comicId, title, titleStartsWith, modifiedSince,
            creators, characters, series, stories, orderBy, limit, offset
        )
    }

    override suspend fun getComicStories(
        comicId: Int,
        modifiedSince: Date?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getComicStories(
            apikey, ts, hash, comicId, modifiedSince,
            series, events, creators, characters, orderBy, limit, offset
        )
    }

    override suspend fun getCreators(
        firstName: String?,
        middleName: String?,
        lastName: String?,
        suffix: String?,
        nameStartsWith: String?,
        firstNameStartsWith: String?,
        middleNameStartsWith: String?,
        lastNameStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCreator> {
        return retrofitClient.getCreators(
            apikey,
            ts,
            hash,
            firstName,
            middleName,
            lastName,
            suffix,
            nameStartsWith,
            firstNameStartsWith,
            middleNameStartsWith,
            lastNameStartsWith,
            modifiedSince,
            comics,
            series,
            events,
            stories,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getCreator(creatorId: Int): MarvelObjectWrapper<MarvelCreator> {
        return retrofitClient.getCreator(apikey, ts, hash, creatorId)
    }

    override suspend fun getCreatorFromUrl(url: String): MarvelObjectWrapper<MarvelCreator> {
        return retrofitClient.getCreatorFromUrl(url, apikey, ts, hash)
    }

    override suspend fun getCreatorComics(
        creatorId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: CommaSepList<String>?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        sharedAppearances: CommaSepList<Int>?,
        collaborators: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getCreatorComics(
            apikey,
            ts,
            hash,
            creatorId,
            format,
            formatType,
            noVariants,
            dateDescriptor,
            dateRange,
            title,
            titleStartsWith,
            startYear,
            issueNumber,
            diamondCode,
            digitalId,
            upc,
            isbn,
            ean,
            issn,
            hasDigitalIssue,
            modifiedSince,
            creators,
            characters,
            series,
            events,
            stories,
            sharedAppearances,
            collaborators,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getCreatorEvents(
        creatorId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getCreatorEvents(
            apikey, ts, hash, creatorId, title, titleStartsWith, modifiedSince,
            characters, series, comics, stories, orderBy, limit, offset
        )
    }

    override suspend fun getCreatorSeries(
        creatorId: Int,
        title: String?,
        titleStartsWith: String?,
        startYear: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        seriesType: String?,
        contains: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelSeries> {
        return retrofitClient.getCreatorSeries(
            apikey,
            ts,
            hash,
            creatorId,
            title,
            titleStartsWith,
            startYear,
            modifiedSince,
            comics,
            stories,
            events,
            characters,
            seriesType,
            contains,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getCreatorStories(
        creatorId: Int,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getCreatorStories(
            apikey, ts, hash, creatorId, modifiedSince,
            comics, series, events, characters, orderBy, limit, offset
        )
    }

    override suspend fun getEvents(
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getEvents(
            apikey, ts, hash, title, titleStartsWith, modifiedSince,
            characters, series, comics, stories, orderBy, limit, offset
        )
    }

    override suspend fun getEvent(eventId: Int): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getEvent(apikey, ts, hash, eventId)
    }

    override suspend fun getEventFromUrl(url: String): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getEventFromUrl(url, apikey, ts, hash)
    }

    override suspend fun getEventCharacters(
        eventId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCharacter> {
        return retrofitClient.getEventCharacters(
            apikey, ts, hash, eventId, title, titleStartsWith, modifiedSince,
            comics, series, stories, orderBy, limit, offset
        )
    }

    override suspend fun getEventComics(
        eventId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: CommaSepList<String>?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        sharedAppearances: CommaSepList<Int>?,
        collaborators: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getEventComics(
            apikey,
            ts,
            hash,
            eventId,
            format,
            formatType,
            noVariants,
            dateDescriptor,
            dateRange,
            title,
            titleStartsWith,
            startYear,
            issueNumber,
            diamondCode,
            digitalId,
            upc,
            isbn,
            ean,
            issn,
            hasDigitalIssue,
            modifiedSince,
            creators,
            characters,
            series,
            events,
            stories,
            sharedAppearances,
            collaborators,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getEventCreators(
        eventId: Int,
        firstName: String?,
        middleName: String?,
        lastName: String?,
        suffix: String?,
        nameStartsWith: String?,
        firstNameStartsWith: String?,
        middleNameStartsWith: String?,
        lastNameStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getEventCreators(
            apikey,
            ts,
            hash,
            eventId,
            firstName,
            middleName,
            lastName,
            suffix,
            nameStartsWith,
            firstNameStartsWith,
            middleNameStartsWith,
            lastNameStartsWith,
            modifiedSince,
            comics,
            series,
            stories,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getEventSeries(
        eventId: Int,
        title: String?,
        titleStartsWith: String?,
        startYear: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        seriesType: String?,
        contains: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelSeries> {
        return retrofitClient.getEventSeries(
            apikey, ts, hash, eventId, title, titleStartsWith, startYear, modifiedSince,
            comics, stories, creators, characters, seriesType, contains, orderBy, limit, offset
        )
    }

    override suspend fun getEventStories(
        eventId: Int,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getEventStories(
            apikey, ts, hash, eventId, modifiedSince,
            comics, series, creators, characters, orderBy, limit, offset
        )
    }

    override suspend fun getSeriesPlural(
        title: String?,
        titleStartsWith: String?,
        startYear: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        seriesType: String?,
        contains: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelSeries> {
        return retrofitClient.getSeriesPlural(
            apikey,
            ts,
            hash,
            title,
            titleStartsWith,
            startYear,
            modifiedSince,
            comics,
            stories,
            events,
            creators,
            characters,
            seriesType,
            contains,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getSeriesSingular(seriesId: Int): MarvelObjectWrapper<MarvelSeries> {
        return retrofitClient.getSeriesSingular(apikey, ts, hash, seriesId)
    }

    override suspend fun getSeriesSingularFromUrl(url: String): MarvelObjectWrapper<MarvelSeries> {
        return retrofitClient.getSeriesSingularFromUrl(url, apikey, ts, hash)
    }

    override suspend fun getSeriesSingularCharacters(
        seriesId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCharacter> {
        return retrofitClient.getSeriesSingularCharacters(
            apikey, ts, hash, seriesId, title, titleStartsWith,
            modifiedSince, comics, events, stories, orderBy, limit, offset
        )
    }

    override suspend fun getSeriesSingularComics(
        seriesId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: CommaSepList<String>?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        sharedAppearances: CommaSepList<Int>?,
        collaborators: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getSeriesSingularComics(
            apikey,
            ts,
            hash,
            seriesId,
            format,
            formatType,
            noVariants,
            dateDescriptor,
            dateRange,
            title,
            titleStartsWith,
            startYear,
            issueNumber,
            diamondCode,
            digitalId,
            upc,
            isbn,
            ean,
            issn,
            hasDigitalIssue,
            modifiedSince,
            creators,
            characters,
            series,
            events,
            stories,
            sharedAppearances,
            collaborators,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getSeriesSingularCreators(
        seriesId: Int,
        firstName: String?,
        middleName: String?,
        lastName: String?,
        suffix: String?,
        nameStartsWith: String?,
        firstNameStartsWith: String?,
        middleNameStartsWith: String?,
        lastNameStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCreator> {
        return retrofitClient.getSeriesSingularCreators(
            apikey,
            ts,
            hash,
            seriesId,
            firstName,
            middleName,
            lastName,
            suffix,
            nameStartsWith,
            firstNameStartsWith,
            middleNameStartsWith,
            lastNameStartsWith,
            modifiedSince,
            comics,
            events,
            stories,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getSeriesSingularEvents(
        seriesId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        comics: CommaSepList<Int>?,
        stories: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getSeriesSingularEvents(
            apikey, ts, hash, seriesId, title, titleStartsWith, modifiedSince,
            creators, characters, comics, stories, orderBy, limit, offset
        )
    }

    override suspend fun getSeriesSingularStories(
        seriesId: Int,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getSeriesSingularStories(
            apikey, ts, hash, seriesId, modifiedSince,
            comics, events, creators, characters, orderBy, limit, offset
        )
    }

    override suspend fun getStories(
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getStories(
            apikey, ts, hash, modifiedSince, comics, series, creators, characters,
            orderBy, limit, offset
        )
    }

    override suspend fun getStory(storyId: Int): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getStory(apikey, ts, hash, storyId)
    }

    override suspend fun getStoryFromUrl(url: String): MarvelObjectWrapper<MarvelStory> {
        return retrofitClient.getStoryFromUrl(url, apikey, ts, hash)
    }

    override suspend fun getStoryCharacters(
        storyId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCharacter> {
        return retrofitClient.getStoryCharacters(
            apikey, ts, hash, storyId, title, titleStartsWith, modifiedSince,
            comics, series, events, orderBy, limit, offset
        )
    }

    override suspend fun getStoryComics(
        storyId: Int,
        format: String?,
        formatType: String?,
        noVariants: Boolean?,
        dateDescriptor: String?,
        dateRange: CommaSepList<String>?,
        title: String?,
        titleStartsWith: String?,
        startYear: Int?,
        issueNumber: Int?,
        diamondCode: String?,
        digitalId: Int?,
        upc: String?,
        isbn: String?,
        ean: String?,
        issn: String?,
        hasDigitalIssue: Boolean?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        sharedAppearances: CommaSepList<Int>?,
        collaborators: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelComic> {
        return retrofitClient.getStoryComics(
            apikey,
            ts,
            hash,
            storyId,
            format,
            formatType,
            noVariants,
            dateDescriptor,
            dateRange,
            title,
            titleStartsWith,
            startYear,
            issueNumber,
            diamondCode,
            digitalId,
            upc,
            isbn,
            ean,
            issn,
            hasDigitalIssue,
            modifiedSince,
            creators,
            characters,
            series,
            events,
            sharedAppearances,
            collaborators,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getStoryCreators(
        storyId: Int,
        firstName: String?,
        middleName: String?,
        lastName: String?,
        suffix: String?,
        nameStartsWith: String?,
        firstNameStartsWith: String?,
        middleNameStartsWith: String?,
        lastNameStartsWith: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelCreator> {
        return retrofitClient.getStoryCreators(
            apikey,
            ts,
            hash,
            storyId,
            firstName,
            middleName,
            lastName,
            suffix,
            nameStartsWith,
            firstNameStartsWith,
            middleNameStartsWith,
            lastNameStartsWith,
            modifiedSince,
            comics,
            series,
            events,
            orderBy,
            limit,
            offset
        )
    }

    override suspend fun getStoryEvents(
        storyId: Int,
        title: String?,
        titleStartsWith: String?,
        modifiedSince: Date?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        series: CommaSepList<Int>?,
        comics: CommaSepList<Int>?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelEvent> {
        return retrofitClient.getStoryEvents(
            apikey, ts, hash, storyId, title, titleStartsWith, modifiedSince,
            creators, characters, series, comics, orderBy, limit, offset
        )
    }

    override suspend fun getStorySeries(
        storyId: Int,
        title: String?,
        titleStartsWith: String?,
        startYear: String?,
        modifiedSince: Date?,
        comics: CommaSepList<Int>?,
        creators: CommaSepList<Int>?,
        characters: CommaSepList<Int>?,
        events: CommaSepList<Int>?,
        seriesType: String?,
        contains: String?,
        orderBy: String?,
        limit: Int?,
        offset: Int?
    ): MarvelObjectWrapper<MarvelSeries> {
        return retrofitClient.getStorySeries(
            apikey, ts, hash, storyId, title, titleStartsWith, startYear, modifiedSince,
            comics, creators, characters, events, seriesType, contains, orderBy, limit, offset
        )
    }
}