package com.example.marveldatabase.presenter.viewmodels

import com.example.marveldatabase.data.repositories.MarvelRepository
import com.example.marveldatabase.framework.MarvelDbDataSourceImpl
import com.example.marveldatabase.usecase.DetailsUseCase
import com.example.marveldatabase.usecase.SearchUseCase

class DetailSingleton {
    companion object {
        val dbDataSource = MarvelDbDataSourceImpl()

        val repository: MarvelRepository = MarvelRepository(dbDataSource)
        val detailsUseCase = DetailsUseCase(repository)

        val searchUseCase: SearchUseCase = SearchUseCase(repository)
        var searchViewModel: SearchViewModel? = null
        fun getsSearchViewModel(entityType: Int): SearchViewModel {
            if (searchViewModel == null) {
                searchViewModel = SearchViewModel(searchUseCase, entityType)
            }
            return searchViewModel!!
        }


    }

}