package com.example.marveldatabase.domain

import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.domain.entities.ui.*

class Mapper {
    companion object {
        fun fromCharacterNetworkToCharacterUI(entity: MarvelCharacter): MarvelCharacterUI {
            return MarvelCharacterUI(
                entity.id, entity.name,
                entity.description, entity.modified, entity.resourceURI,
                entity.urls, entity.thumbnail,
                fromComicResListToComicResListUI(entity.comics),
                fromStoryResListToStoryResListUI(entity.stories),
                fromEventResListToEventResListUI(entity.events),
                fromSeriesResListToSeriesResListUI(entity.series)
            )
        }

        fun fromCreatorNetworkToCreatorUI(entity: MarvelCreator): MarvelCreatorUI {
            return MarvelCreatorUI(
                entity.id, entity.firstName, entity.lastName, entity.middleName,
                entity.suffix, entity.fullName, entity.modified, entity.resourceURI,
                entity.urls, entity.thumbnail,
                fromSeriesResListToSeriesResListUI(entity.series),
                fromStoryResListToStoryResListUI(entity.stories),
                fromComicResListToComicResListUI(entity.comics),
                fromEventResListToEventResListUI(entity.events)
            )
        }

        fun fromComicNetworkToComicUI(entity: MarvelComic): MarvelComicUI {
            return MarvelComicUI(
                entity.id, entity.digitalId, entity.title, entity.issueNumber,
                entity.variantDescription, entity.description, entity.modified, entity.isbn,
                entity.upc, entity.diamondCode, entity.ean, entity.issn, entity.format,
                entity.pageCount, entity.textObjects, entity.resourceURI, entity.urls,
                fromSeriesSummaryToSeriesSummaryUI(entity.series),
                entity.variants?.map { fromComicSummaryToComicSummaryUI(it) },
                entity.collections?.map { fromComicSummaryToComicSummaryUI(it) },
                entity.collectedIssues?.map { fromComicSummaryToComicSummaryUI(it) },
                entity.dates, entity.prices, entity.thumbnail, entity.images,
                fromCreatorResListToCreatorResListUI(entity.creators),
                fromCharacterResListToCharacterResListUI(entity.characters),
                fromStoryResListToStoryResListUI(entity.stories),
                fromEventResListToEventResListUI(entity.events)
            )
        }

        fun fromEventNetworkToEventUI(entity: MarvelEvent): MarvelEventUI {
            return MarvelEventUI(
                entity.id, entity.title, entity.description, entity.resourceURI,
                entity.urls, entity.modified, entity.start, entity.end, entity.thumbnail,
                fromComicResListToComicResListUI(entity.comics),
                fromStoryResListToStoryResListUI(entity.stories),
                fromSeriesResListToSeriesResListUI(entity.series),
                fromCharacterResListToCharacterResListUI(entity.characters),
                fromCreatorResListToCreatorResListUI(entity.creators),
                fromEventSummaryToEventSummaryUI(entity.next),
                fromEventSummaryToEventSummaryUI(entity.previous)
            )
        }

        fun fromStoriesNetworkToStoriesUI(entity: MarvelStory): MarvelStoryUI {
            return MarvelStoryUI(
                entity.id, entity.title, entity.description, entity.resourceURI,
                entity.type, entity.modified, entity.thumbnail,
                fromComicResListToComicResListUI(entity.comics),
                fromSeriesResListToSeriesResListUI(entity.series),
                fromEventResListToEventResListUI(entity.events),
                fromCharacterResListToCharacterResListUI(entity.characters),
                fromCreatorResListToCreatorResListUI(entity.creators),
                fromComicSummaryToComicSummaryUI(entity.originalIssue)
            )
        }

        fun fromSeriesNetworkToSeriesUI(entity: MarvelSeries): MarvelSeriesUI {
            return MarvelSeriesUI(
                entity.id, entity.title, entity.description, entity.resourceURI,
                entity.urls, entity.startDate, entity.endDate, entity.rating, entity.modified,
                entity.thumbnail,
                fromComicResListToComicResListUI(entity.comics),
                fromStoryResListToStoryResListUI(entity.stories),
                fromEventResListToEventResListUI(entity.events),
                fromCharacterResListToCharacterResListUI(entity.characters),
                fromCreatorResListToCreatorResListUI(entity.creators),
                fromSeriesSummaryToSeriesSummaryUI(entity.next),
                fromSeriesSummaryToSeriesSummaryUI(entity.previous)


            )
        }

        fun fromCharacterResListToCharacterResListUI(entity: MarvelResourceList<MarvelCharacterSummary>?): MarvelUIResourceList<MarvelCharacterUISummary> {
            return MarvelUIResourceList(entity?.available, entity?.returned, entity?.collectionURI,
                entity?.items?.map { fromCharacterSummaryToCharacterSummaryUI(it) })
        }

        fun fromComicResListToComicResListUI(entity: MarvelResourceList<MarvelComicSummary>?): MarvelUIResourceList<MarvelComicUISummary> {
            return MarvelUIResourceList(entity?.available, entity?.returned, entity?.collectionURI,
                entity?.items?.map { fromComicSummaryToComicSummaryUI(it) })
        }

        fun fromCreatorResListToCreatorResListUI(entity: MarvelResourceList<MarvelCreatorSummary>?): MarvelUIResourceList<MarvelCreatorUISummary> {
            return MarvelUIResourceList(entity?.available, entity?.returned, entity?.collectionURI,
                entity?.items?.map { fromCreatorSummaryToCreatorSummaryUI(it) })
        }

        fun fromEventResListToEventResListUI(entity: MarvelResourceList<MarvelEventSummary>?): MarvelUIResourceList<MarvelEventUISummary> {
            return MarvelUIResourceList(entity?.available, entity?.returned, entity?.collectionURI,
                entity?.items?.map { fromEventSummaryToEventSummaryUI(it) })
        }

        fun fromStoryResListToStoryResListUI(entity: MarvelResourceList<MarvelStorySummary>?): MarvelUIResourceList<MarvelStoryUISummary> {
            return MarvelUIResourceList(entity?.available, entity?.returned, entity?.collectionURI,
                entity?.items?.map { fromStorySummaryToStorySummaryUI(it) })
        }

        fun fromSeriesResListToSeriesResListUI(entity: MarvelResourceList<MarvelSeriesSummary>?): MarvelUIResourceList<MarvelSeriesUISummary> {
            return MarvelUIResourceList(entity?.available, entity?.returned, entity?.collectionURI,
                entity?.items?.map { fromSeriesSummaryToSeriesSummaryUI(it) })
        }

        fun fromCharacterSummaryToCharacterSummaryUI(entity: MarvelCharacterSummary?): MarvelCharacterUISummary {
            return MarvelCharacterUISummary(entity?.resourceURI, entity?.name, entity?.role)
        }

        fun fromComicSummaryToComicSummaryUI(entity: MarvelComicSummary?): MarvelComicUISummary {
            return MarvelComicUISummary(entity?.resourceURI, entity?.name)
        }

        fun fromCreatorSummaryToCreatorSummaryUI(entity: MarvelCreatorSummary?): MarvelCreatorUISummary {
            return MarvelCreatorUISummary(entity?.resourceURI, entity?.name, entity?.role)
        }

        fun fromEventSummaryToEventSummaryUI(entity: MarvelEventSummary?): MarvelEventUISummary {
            return MarvelEventUISummary(entity?.resourceURI, entity?.name)
        }

        fun fromSeriesSummaryToSeriesSummaryUI(entity: MarvelSeriesSummary?): MarvelSeriesUISummary {
            return MarvelSeriesUISummary(entity?.resourceURI, entity?.name)
        }

        fun fromStorySummaryToStorySummaryUI(entity: MarvelStorySummary?): MarvelStoryUISummary {
            return MarvelStoryUISummary(entity?.resourceURI, entity?.name, entity?.type)
        }
    }

}