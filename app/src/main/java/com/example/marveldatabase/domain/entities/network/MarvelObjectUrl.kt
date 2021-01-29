package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelObjectUrl(
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
) {
}