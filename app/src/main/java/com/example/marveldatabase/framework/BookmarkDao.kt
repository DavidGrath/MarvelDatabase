package com.example.marveldatabase.framework

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marveldatabase.framework.entities.Bookmark

@Dao
abstract class BookmarkDao {
    @Query("SELECT * FROM Bookmark WHERE id = :id")
    abstract fun getBookmark(id: Int): Bookmark

    @Insert
    abstract suspend fun addBookmark(bookmark: Bookmark)

    @Query("DELETE FROM Bookmark WHERE id = :id")
    abstract suspend fun deleteBookmark(id: Int)

    @Query("SELECT * FROM Bookmark")
    abstract fun getAllBookmarks(): List<Bookmark>
}