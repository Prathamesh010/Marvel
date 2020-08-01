package com.example.marvelclient.comic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelclient.database.ComicRepository
import com.example.marvelclient.model.comic.Comic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComicViewModel(
    private val repository: ComicRepository
) : ViewModel() {

    init {
        viewModelScope.launch{
            repository.refreshComic()
        }
    }

    fun getComics(): LiveData<List<Comic>> = repository.getComic()
}