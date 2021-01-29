package com.example.marveldatabase.presenter.viewmodels

import com.example.marveldatabase.domain.Mapper
import com.example.marveldatabase.domain.entities.ui.MarvelUIEntity
import com.example.marveldatabase.usecase.SearchUseCase
import com.example.marveldatabase.utils.Constants
import com.example.marveldatabase.utils.ObservableTemp
import com.example.marveldatabase.utils.ResultValue
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchViewModel(val useCase: SearchUseCase, val entityType: Int) {

    var entities: List<MarvelUIEntity>? = ArrayList<MarvelUIEntity>()
    val charactersLiveData: ObservableTemp<ResultValue<List<MarvelUIEntity>?>> =
        ObservableTemp(ResultValue.Success(entities))

    fun search(searchTerm: String) {
        when (entityType) {
            Constants.MARVEL_ENTITY_CHARACTER -> {
                searchCharacters(searchTerm)
            }
            Constants.MARVEL_ENTITY_COMIC -> {
                searchComics(searchTerm)
            }
            Constants.MARVEL_ENTITY_CREATOR -> {
                searchCreators(searchTerm)
            }
            Constants.MARVEL_ENTITY_EVENT -> {
                searchEvents(searchTerm)
            }
            Constants.MARVEL_ENTITY_SERIES -> {
                searchSeries(searchTerm)
            }
        }
    }

    fun searchCharacters(searchTerm: String) {
        charactersLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.searchCharacters(searchTerm)
            val resultValue: ResultValue<List<MarvelUIEntity>?> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(res.data!!.map {
                            Mapper.fromCharacterNetworkToCharacterUI(
                                it
                            )
                        })
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            charactersLiveData.setValue(resultValue)
        }

    }

    fun searchComics(titleSearch: String) {
        charactersLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.searchComics(titleSearch)
            val resultValue: ResultValue<List<MarvelUIEntity>?> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(res.data!!.map { Mapper.fromComicNetworkToComicUI(it) })
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            charactersLiveData.setValue(resultValue)
        }

    }

    fun searchCreators(firstName: String) {
        charactersLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.searchCreator(firstName)
            val resultValue: ResultValue<List<MarvelUIEntity>?> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(res.data!!.map { Mapper.fromCreatorNetworkToCreatorUI(it) })
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            charactersLiveData.setValue(resultValue)
        }

    }

    fun searchEvents(titleSearch: String) {
        charactersLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.searchEvent(titleSearch)
            val resultValue: ResultValue<List<MarvelUIEntity>?> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(res.data!!.map { Mapper.fromEventNetworkToEventUI(it) })
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            charactersLiveData.setValue(resultValue)
        }

    }

    fun searchSeries(titleSearch: String) {
        charactersLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.searchSeries(titleSearch)
            val resultValue: ResultValue<List<MarvelUIEntity>?> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(res.data!!.map { Mapper.fromSeriesNetworkToSeriesUI(it) })
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            charactersLiveData.setValue(resultValue)
        }

    }
}