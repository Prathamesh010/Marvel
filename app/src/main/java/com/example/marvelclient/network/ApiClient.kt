package com.example.marvelclient.network

import com.example.marvelclient.model.character.CharacterResponse
import com.example.marvelclient.model.comic.ComicResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("v1/public/characters")
    suspend fun getCharacters(@Query("ts")ts:String,
                              @Query("apikey")apikey: String,
                              @Query("hash")hash: String,
                              @Query("limit")limit: Int,
                              @Query("orderBy")orderBy: String): CharacterResponse

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getComicOfCharacter(@Path("characterId")id: String,
                                    @Query("ts")ts:String,
                                    @Query("apikey")apikey: String,
                                    @Query("hash")hash: String,
                                    @Query("orderBy")orderBy: String): ComicResponse

    @GET("/v1/public/comics")
    suspend fun getComic(@Query("ts")ts:String,
                         @Query("apikey")apikey: String,
                         @Query("hash")hash: String,
                         @Query("limit")limit: Int,
                         @Query("orderBy")orderBy: String): ComicResponse
}