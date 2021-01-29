package com.example.marveldatabase.usecase

import com.example.marveldatabase.data.repositories.MarvelRepository
import com.example.marveldatabase.framework.entities.Bookmark

class BookmarkUseCase(val repository: MarvelRepository) : UseCase {
    fun getBookmarks(): List<Bookmark> {
        return repository.getBookmarks()
    }

    fun deleteBookmark(id: Int) {
        repository.deleteBookmark(id)
    }
}