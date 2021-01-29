package com.example.marveldatabase.data.entities

data class MarvelResourceListData<T>(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<T>
) {
}