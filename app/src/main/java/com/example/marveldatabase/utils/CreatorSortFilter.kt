package com.example.marveldatabase.utils

import java.util.*

data class CreatorSortFilter(
    val firstName: String?,
    val middleName: String?,
    val lastName: String?,
    val suffix: String?,
    val nameStartsWith: String?,
    val firstNameStartsWith: String?,
    val middleNameStartsWith: String?,
    val lastNameStartsWith: String?,
    val modifiedSince: Date?,
    val comics: CommaSepList<Int>?,
    val series: CommaSepList<Int>?,
    val events: CommaSepList<Int>?,
    val stories: CommaSepList<Int>?,
    val orderBy: String?,
    val limit: Int?,
    val offset: Int?
) {
}