package com.example.marvelclient.database

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.marvelclient.avengers.Avenger
import com.example.marvelclient.model.comic.Comic
import com.example.marvelclient.model.comic.ComicResponse
import com.example.marvelclient.network.ApiClient
import com.example.marvelclient.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

private const val PRIVATE_KEY = "f3d32a46490f42e7e5f716edd7a06bc5fcb45ef1"
private const val API_KEY = "9b8c1987a0633ffd00b9b10f84daaf5c"

class CharacterRepository(
    private val service: ApiClient,
    private val dao: Dao
) {
    private val timeStamp = Date().time.toString()
    private val hash = Utils().md5(timeStamp + PRIVATE_KEY + API_KEY)

    suspend fun refreshCharacter() {
        try {
            val response = service.getCharacters( 100,"-modified").data.results
            for (character in response) {
                dao.insertCharacters(characters = character)
            }
        }catch (e: Exception){
            Log.i("exception",e.stackTrace.toString())
        }
    }

    suspend fun getCharacterComics(id:Int): List<Comic>? {
        try {
            return withContext(Dispatchers.IO) {
                val response = service
                    .getComicOfCharacter(id.toString(), "-modified").data.comics
                for (comic in response)
                    dao.insertComics(comic)
                return@withContext response
            }
        }catch (e:Exception){
            Log.i("exception",e.stackTrace.toString())
        }
        return null
    }

    fun getCharacterById(id: Int) = dao.getCharacterById(id.toString())

    fun getCharacter() = dao.getCharacters()

    suspend fun insertAvenger(avenger: Avenger) = dao.insertAvenger(avenger)

    fun getAvengers() = dao.getAvengers()

    fun ifAvengerExists(id: Int) = dao.getAvengerById(id.toString())
}