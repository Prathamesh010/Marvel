package com.example.marvelclient.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelclient.avengers.Avenger
import com.example.marvelclient.model.comic.Comic
import com.example.marvelclient.model.character.Character

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: Character)

    @Query("SELECT * FROM character_table")
    fun getCharacters(): LiveData<List<Character>>

    @Query("SELECT * FROM character_table WHERE id = :id")
    fun getCharacterById(id: String): LiveData<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComics(comics: Comic)

    @Query("SELECT * FROM comic_table")
    fun getComics(): LiveData<List<Comic>>

    @Query("SELECT * FROM comic_table WHERE id = :id")
    fun getComicById(id: String): LiveData<Comic>

    @Query("SELECT * FROM avenger_table")
    fun getAvengers(): LiveData<List<Avenger>>
    
    @Query("SELECT * FROM avenger_table WHERE id = :id")
    fun getAvengerById(id: String): LiveData<Avenger>?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAvenger(avenger: Avenger)
    
}