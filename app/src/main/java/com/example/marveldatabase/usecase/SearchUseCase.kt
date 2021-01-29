package com.example.marveldatabase.usecase

import com.example.marveldatabase.data.repositories.MarvelRepository
import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.utils.ResultValue

class SearchUseCase(val repository: MarvelRepository) {
    suspend fun searchCharacters(searchTerm: String): ResultValue<List<MarvelCharacter>?> {
        return repository.searchCharacters(searchTerm)
    }

    suspend fun searchComics(titleSearch: String): ResultValue<List<MarvelComic>?> {
        return repository.searchComics(titleSearch)
    }

    suspend fun searchCreator(firstName: String): ResultValue<List<MarvelCreator>?> {
        return repository.searchCreators(firstName)
    }

    suspend fun searchEvent(titleSearch: String): ResultValue<List<MarvelEvent>?> {
        return repository.searchEvents(titleSearch)
    }

    suspend fun searchSeries(titleSearch: String): ResultValue<List<MarvelSeries>?> {
        return repository.searchSeries(titleSearch)
    }
}