package com.example.marveldatabase.presenter.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marveldatabase.presenter.viewmodels.DetailsViewModel
import com.example.marveldatabase.usecase.DetailsUseCase

class DetailsViewModelFactory(private val useCase: DetailsUseCase) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(useCase) as T
    }
}