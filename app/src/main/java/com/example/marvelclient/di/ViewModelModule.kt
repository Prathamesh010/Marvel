package com.example.marvelclient.di

import com.example.marvelclient.avengers.AvengersViewModel
import com.example.marvelclient.character.CharacterViewModel
import com.example.marvelclient.characterDetail.CharacterDetailViewModel
import com.example.marvelclient.comic.ComicViewModel
import com.example.marvelclient.comicDetail.ComicDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { ComicViewModel(get()) }
    viewModel { CharacterDetailViewModel(get()) }
    viewModel { ComicDetailViewModel(get()) }
    viewModel{ AvengersViewModel(get()) }
}