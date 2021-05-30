package com.example.marvelclient.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvelclient.avengers.Avenger
import com.example.marvelclient.model.character.Character
import com.example.marvelclient.model.comic.Comic

@Database(entities = [Character::class,Comic::class,Avenger::class],version = 1,exportSchema = false)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun dao(): Dao
}