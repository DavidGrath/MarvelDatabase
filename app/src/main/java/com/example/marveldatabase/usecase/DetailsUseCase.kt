package com.example.marveldatabase.usecase

import com.example.marveldatabase.data.repositories.MarvelRepository
import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.utils.ResultValue

class DetailsUseCase(val repository: MarvelRepository) : UseCase {
    suspend fun getCharacterFromUrl(url: String): ResultValue<MarvelCharacter?> {
        return repository.getCharacterFromUrl(url)
    }

    suspend fun getComicFromUrl(url: String): ResultValue<MarvelComic?> {
        return repository.getComicFromUrl(url)
    }

    suspend fun getCreatorFromUrl(url: String): ResultValue<MarvelCreator?> {
        return repository.getCreatorFromUrl(url)
    }

    suspend fun getEventFromUrl(url: String): ResultValue<MarvelEvent?> {
        return repository.getEventFromUrl(url)
    }

    suspend fun getSeriesSingularFromUrl(url: String): ResultValue<MarvelSeries?> {
        return repository.getSeriesSingularFromUrl(url)
    }

    suspend fun getStoryFromUrl(url: String): ResultValue<MarvelStory?> {
        return repository.getStoryFromUrl(url)
    }
}