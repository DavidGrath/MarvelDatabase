package com.example.marveldatabase.domain.entities.network

import com.google.gson.annotations.SerializedName

data class MarvelComicPrice(
    @SerializedName("type")
    val type: String?,
    //All prices in USD
    @SerializedName("price")
    val price: Float?
) {

}