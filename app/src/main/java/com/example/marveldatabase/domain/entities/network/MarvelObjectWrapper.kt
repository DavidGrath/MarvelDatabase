package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelObjectWrapper<T : MarvelEntity>(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("data")
    val data: MarvelObjectContainer<T>?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("attributionHtml")
    val attributionHtml: String?
) {
}