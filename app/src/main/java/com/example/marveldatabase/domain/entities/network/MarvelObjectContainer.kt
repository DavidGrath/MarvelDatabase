package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelObjectContainer<T : MarvelEntity>(
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("results")
    val results: List<T>?
) {
}