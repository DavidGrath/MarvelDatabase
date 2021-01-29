package com.example.marveldatabase.utils

import java.util.*

data class CharacterSortFilter(
    val name: String?,
    val nameStartsWith: String?,
    val modifiedSince: Date?,
    val comics: CommaSepList<Int>?,
    val series: CommaSepList<Int>?,
    val events: CommaSepList<Int>?,
    val stories: CommaSepList<Int>?,
    val orderByName: Boolean = false,
    val nameAscDesc: Int = Constants.SORT_ORDER_ASCENDING,
    val orderByModified: Boolean = false,
    val modifiedAscDesc: Int = Constants.SORT_ORDER_ASCENDING,
    val limit: Int?,
    val offset: Int?
) {
}