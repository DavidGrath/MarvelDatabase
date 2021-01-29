package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelObjectImage(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
) {
}