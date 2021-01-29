package com.example.marveldatabase.utils

import java.util.*

data class EventSortFilter(
    val title: String?,
    val titleStartsWith: String?,
    val modifiedSince: Date?,
    val characters: CommaSepList<Int>?,
    val series: CommaSepList<Int>?,
    val comics: CommaSepList<Int>?,
    val stories: CommaSepList<Int>?,
    val orderBy: String?,
    val limit: Int?,
    val offset: Int?
) {
}