package com.example.marveldatabase.utils

import java.util.*

data class ComicSortFilter(
    val format: String?,
    val formatType: String?,
    val dateDescriptor: String?,
    val dateRange: CommaSepList<String>?,
    val title: String?,
    val titleStartsWith: String?,
    val startYear: Int?,
    val issueNumber: Int?,
    val diamondCode: Int?,
    val digitalId: Int,
    val upc: String?,
    val isbn: String?,
    val ean: String?,
    val issn: String?,
    val hasDigitalIssue: Boolean?,
    val modifiedSince: Date?,
    val creators: CommaSepList<Int>?,
    val characters: CommaSepList<Int>?,
    val series: CommaSepList<Int>?,
    val events: CommaSepList<Int>?,
    val stories: CommaSepList<Int>?,
    val sharedAppearances: CommaSepList<Int>?,
    val collaborators: CommaSepList<Int>?,
    val orderBy: String?,
    val limit: Int?,
    val offset: Int?
) {
}