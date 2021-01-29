package com.example.marveldatabase.presenter.fragments

import com.example.marveldatabase.domain.entities.ui.MarvelUIEntity

interface NextEntityFragListener {
    fun onNextEntitySelected(entity: MarvelUIEntity)
}