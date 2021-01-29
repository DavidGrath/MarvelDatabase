package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelSeriesSummary(
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("name")
    val name: String?
) : MarvelSummary {
}