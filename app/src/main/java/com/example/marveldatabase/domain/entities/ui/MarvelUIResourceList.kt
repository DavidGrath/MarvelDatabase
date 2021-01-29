package com.example.marveldatabase.domain.entities.ui

data class MarvelUIResourceList<T : MarvelUISummary>(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<T>?
) {
}