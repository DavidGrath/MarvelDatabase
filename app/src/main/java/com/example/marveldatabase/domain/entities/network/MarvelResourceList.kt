package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelResourceList<T : MarvelSummary>(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("returned")
    val returned: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<T>?
) {
}