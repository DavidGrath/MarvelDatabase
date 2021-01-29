package com.example.marveldatabase.data.repositories

import com.example.marveldatabase.data.MarvelWebDataSource
import com.example.marveldatabase.utils.ResultValue
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class MarvelRepositoryTest {

    lateinit var marvelAPIFailure: MarvelWebDataSource
    lateinit var marvelAPISuccess: MarvelWebDataSource
    lateinit var repository: MarvelRepository

    @Before
    fun setUp() {
//        marvelAPIFailure = object : MarvelWebDataSource {
//            override suspend fun getCharacters(
//                name: String?,
//                nameStartsWith: String?,
//                modifiedSince: Date?,
//                comics: CommaSepList<Int>?,
//                seriesId: CommaSepList<Int>?,
//                events: CommaSepList<Int>?,
//                stories: CommaSepList<Int>?,
//                orderBy: String?,
//                limit: Int?,
//                offset: Int?
//            ): MarvelObjectWrapper<MarvelCharacter> {
//                delay(2_000)
//                throw Exception()
//            }
//
//        }
//        repository = MarvelRepository(object : MarvelDbDataSource{
//            override fun getBookmarks(): List<Bookmark> {
//                throw Exception()
//            }
//
//            override fun deleteBookmark(id: Int) {
//                throw Exception()
//            }
//
//            override fun getBookmark(id: Int): Bookmark {
//                throw Exception()
//            }
//        })
    }

    @After
    fun tearDown() {
    }

    @Test
    fun searchCharactersExceptionReturnsFailure() = runBlocking {
        val result = repository.searchCharacters("Fart")
        assertThat(result, `is`(instanceOf(ResultValue.Failure::class.java)))
    }
}