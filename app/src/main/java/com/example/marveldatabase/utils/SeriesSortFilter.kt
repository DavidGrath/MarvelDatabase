package com.example.marveldatabase.utils

import java.util.*

data class SeriesSortFilter(
    val title: String?,
    val titleStartsWith: String?,
    val startYear: String?,
    val modifiedSince: Date?,
    val comics: CommaSepList<Int>?,
    val stories: CommaSepList<Int>?,
    val events: CommaSepList<Int>?,
    val creators: CommaSepList<Int>?,
    val characters: CommaSepList<Int>?,
    val seriesType: String?,
    val contains: String?,
    val orderBy: String?,
    val limit: Int?,
    val offset: Int?
) {
}