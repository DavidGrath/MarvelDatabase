package com.example.marveldatabase.utils

import java.util.*

data class StorySortFilter(
    val modifiedSince: Date?,
    val comics: CommaSepList<Int>?,
    val series: CommaSepList<Int>?,
    val creators: CommaSepList<Int>?,
    val characters: CommaSepList<Int>?,
    val orderBy: String?,
    val limit: Int?,
    val offset: Int?
) {
}