package com.example.marveldatabase.framework.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bookmark(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: Int,
    val name: String
) {
}