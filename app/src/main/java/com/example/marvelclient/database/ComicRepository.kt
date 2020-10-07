package com.example.marvelclient.database

import android.util.Log
import com.example.marvelclient.network.ApiClient
import com.example.marvelclient.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class ComicRepository(
    private val service: ApiClient,
    private val dao: Dao
) {

    suspend fun refreshComic() {
        withContext(Dispatchers.IO) {
            val response = service.getComic( 100, "-modified")
            val comics = response.data.comics
            for (comic in comics)
                dao.insertComics(comic)
        }
    }

    fun getComic() = dao.getComics()

    fun getComicById(id: Int) = dao.getComicById(id.toString())
}