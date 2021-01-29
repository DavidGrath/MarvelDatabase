package com.example.marveldatabase.data.repositories

import com.example.marveldatabase.data.MarvelDbDataSource
import com.example.marveldatabase.data.MarvelWebDataSource
import com.example.marveldatabase.domain.entities.network.*
import com.example.marveldatabase.framework.MarvelRetrofitClient
import com.example.marveldatabase.framework.MarvelWebDataSourceImpl
import com.example.marveldatabase.framework.entities.Bookmark
import com.example.marveldatabase.utils.CharacterSortFilter
import com.example.marveldatabase.utils.Constants
import com.example.marveldatabase.utils.ResultValue
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelRepository(val database: MarvelDbDataSource) {
    val networkSource: MarvelWebDataSource

    init {
        val interceptor =
            HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder()./*addInterceptor(interceptor).*/build()
        val gson = GsonBuilder()
            .setDateFormat(Constants.MARVEL_DATE_FORMAT)
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.MARVEL_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        networkSource = MarvelWebDataSourceImpl(
            retrofit.create(MarvelRetrofitClient::class.java)
        )
    }

    fun getBookmarks(): List<Bookmark> = database.getBookmarks()
    fun getBookmark(id: Int): Bookmark = database.getBookmark(id)
    fun deleteBookmark(id: Int) = database.deleteBookmark(id)
    fun addBookmark(bookmark: Bookmark) = database.addBookmark(bookmark)

    suspend fun getCharacters(): ResultValue<List<MarvelCharacter>?> {
        val resultValue: ResultValue<List<MarvelCharacter>?> = try {
            ResultValue.Success(networkSource.getCharacters().data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getCharacters(sortFilter: CharacterSortFilter): ResultValue<List<MarvelCharacter>?> {
        val resultValue: ResultValue<List<MarvelCharacter>?> = try {
            ResultValue.Success(networkSource.getCharacters(sortFilter.name).data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getCharacter(characterId: Int): ResultValue<MarvelCharacter?> {
        val resultValue: ResultValue<MarvelCharacter?> = try {
            ResultValue.Success(networkSource.getCharacter(characterId).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getCharacterFromUrl(url: String): ResultValue<MarvelCharacter?> {
        val resultValue: ResultValue<MarvelCharacter?> = try {
            ResultValue.Success(networkSource.getCharacterFromUrl(url).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun searchCharacters(searchTerm: String): ResultValue<List<MarvelCharacter>?> {
        val resultValue: ResultValue<List<MarvelCharacter>?> = try {
            ResultValue.Success(networkSource.getCharacters(nameStartsWith = searchTerm).data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }


    suspend fun getCreators(): ResultValue<List<MarvelCreator>?> {
        val resultValue: ResultValue<List<MarvelCreator>?> = try {
            ResultValue.Success(networkSource.getCreators().data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getCreator(creatorId: Int): ResultValue<MarvelCreator?> {
        val resultValue: ResultValue<MarvelCreator?> = try {
            ResultValue.Success(networkSource.getCreator(creatorId).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getCreatorFromUrl(url: String): ResultValue<MarvelCreator?> {
        val resultValue: ResultValue<MarvelCreator?> = try {
            ResultValue.Success(networkSource.getCreatorFromUrl(url).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun searchCreators(firstName: String): ResultValue<List<MarvelCreator>?> {
        val resultValue: ResultValue<List<MarvelCreator>?> = try {
            ResultValue.Success(networkSource.getCreators(firstNameStartsWith = firstName).data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }


    suspend fun getComics(): ResultValue<List<MarvelComic>?> {
        val resultValue: ResultValue<List<MarvelComic>?> = try {
            ResultValue.Success(networkSource.getComics().data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getComic(comicId: Int): ResultValue<MarvelComic?> {
        val resultValue: ResultValue<MarvelComic?> = try {
            ResultValue.Success(networkSource.getComic(comicId).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getComicFromUrl(url: String): ResultValue<MarvelComic?> {
        val resultValue: ResultValue<MarvelComic?> = try {
            ResultValue.Success(networkSource.getComicFromUrl(url).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun searchComics(titleSearch: String): ResultValue<List<MarvelComic>?> {
        val resultValue: ResultValue<List<MarvelComic>?> = try {
            ResultValue.Success(networkSource.getComics(titleStartsWith = titleSearch).data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }


    suspend fun getEvents(): ResultValue<List<MarvelEvent>?> {
        val resultValue: ResultValue<List<MarvelEvent>?> = try {
            ResultValue.Success(networkSource.getEvents().data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getEvent(eventId: Int): ResultValue<MarvelEvent?> {
        val resultValue: ResultValue<MarvelEvent?> = try {
            ResultValue.Success(networkSource.getEvent(eventId).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getEventFromUrl(url: String): ResultValue<MarvelEvent?> {
        val resultValue: ResultValue<MarvelEvent?> = try {
            ResultValue.Success(networkSource.getEventFromUrl(url).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun searchEvents(titleSearch: String): ResultValue<List<MarvelEvent>?> {
        val resultValue: ResultValue<List<MarvelEvent>?> = try {
            ResultValue.Success(networkSource.getEvents(titleStartsWith = titleSearch).data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }


    suspend fun getSeriesPlural(): ResultValue<List<MarvelSeries>?> {
        val resultValue: ResultValue<List<MarvelSeries>?> = try {
            ResultValue.Success(networkSource.getSeriesPlural().data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getSeriesSingular(seriesId: Int): ResultValue<MarvelSeries?> {
        val resultValue: ResultValue<MarvelSeries?> = try {
            ResultValue.Success(networkSource.getSeriesSingular(seriesId).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getSeriesSingularFromUrl(url: String): ResultValue<MarvelSeries?> {
        val resultValue: ResultValue<MarvelSeries?> = try {
            ResultValue.Success(networkSource.getSeriesSingularFromUrl(url).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun searchSeries(titleSearch: String): ResultValue<List<MarvelSeries>?> {
        val resultValue: ResultValue<List<MarvelSeries>?> = try {
            ResultValue.Success(networkSource.getSeriesPlural(titleStartsWith = titleSearch).data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }


    suspend fun getStories(): ResultValue<List<MarvelStory>?> {
        val resultValue: ResultValue<List<MarvelStory>?> = try {
            ResultValue.Success(networkSource.getStories().data?.results)
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getStoryFromUrl(url: String): ResultValue<MarvelStory?> {
        val resultValue: ResultValue<MarvelStory?> = try {
            ResultValue.Success(networkSource.getStoryFromUrl(url).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }

    suspend fun getStory(storyId: Int): ResultValue<MarvelStory?> {
        val resultValue: ResultValue<MarvelStory?> = try {
            ResultValue.Success(networkSource.getStory(storyId).data?.results?.get(0))
        } catch (e: Exception) {
            e.printStackTrace()
            ResultValue.Failure(null, e.message)
        }
        return resultValue
    }
}