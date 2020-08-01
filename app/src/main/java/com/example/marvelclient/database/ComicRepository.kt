package com.example.marvelclient.database

import android.util.Log
import com.example.marvelclient.network.ApiClient
import com.example.marvelclient.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

private const val PRIVATE_KEY = "f3d32a46490f42e7e5f716edd7a06bc5fcb45ef1"
private const val API_KEY = "9b8c1987a0633ffd00b9b10f84daaf5c"
class ComicRepository(
    private val service: ApiClient,
    private val dao: Dao
) {
    private val timeStamp = Date().time.toString()
    private val hash = Utils().md5(timeStamp + PRIVATE_KEY + API_KEY)

    suspend fun refreshComic() {
        withContext(Dispatchers.IO) {
            val response = service.getComic(timeStamp, API_KEY, hash, 100, "-modified")
            val comics = response.data.comics
            for (comic in comics)
                dao.insertComics(comic)
        }
    }

    fun getComic() = dao.getComics()

    fun getComicById(id: Int) = dao.getComicById(id.toString())
}