package com.example.marvelclient.di

import androidx.room.Room
import com.example.marvelclient.database.MarvelDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MarvelDatabase::class.java,
            "marvel_db"
        ).fallbackToDestructiveMigration().build()
    }

    single {
        get<MarvelDatabase>().dao()
    }
}