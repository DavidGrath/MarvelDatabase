package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarvelComicDate(
    @SerializedName("type")
    val type: String?,
    @SerializedName("date")
    val date: Date?
) {
}