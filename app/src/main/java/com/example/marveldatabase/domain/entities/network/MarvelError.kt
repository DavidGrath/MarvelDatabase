package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelError(
    @SerializedName("code")
    val code: Int,
    @SerializedName("status")
    val status: String
) {
}