package com.example.marvelclient.di

import com.example.marvelclient.database.CharacterRepository
import com.example.marvelclient.database.ComicRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        CharacterRepository(get(),get())
    }

    single{
        ComicRepository(get(),get())
    }
}