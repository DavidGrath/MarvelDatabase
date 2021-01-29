package com.example.marveldatabase.framework

import com.example.marveldatabase.data.MarvelDbDataSource
import com.example.marveldatabase.framework.entities.Bookmark
import kotlinx.coroutines.runBlocking

class MarvelDbDataSourceImpl : MarvelDbDataSource {
    lateinit var dao: BookmarkDao
    override fun getBookmarks(): List<Bookmark> {
        return dao.getAllBookmarks()
    }

    override fun deleteBookmark(id: Int) = runBlocking {
        dao.deleteBookmark(id)
    }

    override fun getBookmark(id: Int): Bookmark {
        return dao.getBookmark(id)
    }

    override fun addBookmark(bookmark: Bookmark) = runBlocking {
        dao.addBookmark(bookmark)
    }
}