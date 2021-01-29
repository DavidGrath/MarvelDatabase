package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelObjectText(
    @SerializedName("type")
    val type: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("text")
    val text: String
) {
}