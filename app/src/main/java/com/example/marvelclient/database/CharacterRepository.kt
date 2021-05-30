package com.example.marvelclient.database

import android.util.Log
import com.example.marvelclient.avengers.Avenger
import com.example.marvelclient.model.comic.Comic
import com.example.marvelclient.network.ApiClient
import com.example.marvelclient.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*


class CharacterRepository(
    private val service: ApiClient,
    private val dao: Dao
) {

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