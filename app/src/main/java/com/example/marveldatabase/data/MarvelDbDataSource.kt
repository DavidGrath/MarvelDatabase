package com.example.marveldatabase.data

import com.example.marveldatabase.framework.entities.Bookmark

interface MarvelDbDataSource {
    fun getBookmarks(): List<Bookmark>
    fun deleteBookmark(id: Int)
    fun getBookmark(id: Int): Bookmark
    fun addBookmark(bookmark: Bookmark)
}