package com.example.marvelclient.comicDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.marvelclient.database.ComicRepository
import com.example.marvelclient.model.comic.Comic


class ComicDetailViewModel(
    private val repository: ComicRepository
) : ViewModel() {
    fun getComic(id: Int): LiveData<Comic> = repository.getComicById(id)
}