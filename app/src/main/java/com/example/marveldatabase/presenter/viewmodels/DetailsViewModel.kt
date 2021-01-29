package com.example.marveldatabase.presenter.viewmodels

import androidx.lifecycle.ViewModel
import com.example.marveldatabase.domain.Mapper
import com.example.marveldatabase.domain.entities.ui.MarvelUIEntity
import com.example.marveldatabase.usecase.DetailsUseCase
import com.example.marveldatabase.utils.ObservableTemp
import com.example.marveldatabase.utils.ResultValue
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsViewModel(val useCase: DetailsUseCase) : ViewModel() {
    lateinit var nextUIEntity: MarvelUIEntity
    val nextEntityLiveData: ObservableTemp<ResultValue<MarvelUIEntity>> =
        ObservableTemp(ResultValue.Waiting<MarvelUIEntity>(null))

    fun getCharacterFromUrl(url: String) {
        nextEntityLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.getCharacterFromUrl(url)
            val resultValue: ResultValue<MarvelUIEntity> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(Mapper.fromCharacterNetworkToCharacterUI(res.data!!))
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            nextEntityLiveData.setValue(resultValue)
        }
    }

    fun getComicFromUrl(url: String) {
        nextEntityLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.getComicFromUrl(url)
            val resultValue: ResultValue<MarvelUIEntity> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(Mapper.fromComicNetworkToComicUI(res.data!!))
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            nextEntityLiveData.setValue(resultValue)
        }
    }

    fun getCreatorFromUrl(url: String) {
        nextEntityLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.getCreatorFromUrl(url)
            val resultValue: ResultValue<MarvelUIEntity> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(Mapper.fromCreatorNetworkToCreatorUI(res.data!!))
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            nextEntityLiveData.setValue(resultValue)
        }
    }

    fun getEventFromUrl(url: String) {
        nextEntityLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.getEventFromUrl(url)
            val resultValue: ResultValue<MarvelUIEntity> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(Mapper.fromEventNetworkToEventUI(res.data!!))
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            nextEntityLiveData.setValue(resultValue)
        }
    }

    fun getSeriesSingularFromUrl(url: String) {
        nextEntityLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.getSeriesSingularFromUrl(url)
            val resultValue: ResultValue<MarvelUIEntity> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(Mapper.fromSeriesNetworkToSeriesUI(res.data!!))
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            nextEntityLiveData.setValue(resultValue)
        }
    }

    fun getStoryFromUrl(url: String) {
        nextEntityLiveData.setValue(ResultValue.Waiting(null))
        GlobalScope.launch {
            val res = useCase.getStoryFromUrl(url)
            val resultValue: ResultValue<MarvelUIEntity> =
                when (res) {
                    is ResultValue.Success -> {
                        ResultValue.Success(Mapper.fromStoriesNetworkToStoriesUI(res.data!!))
                    }
                    else -> {
                        ResultValue.Failure(null)
                    }
                }

            nextEntityLiveData.setValue(resultValue)
        }
    }
}