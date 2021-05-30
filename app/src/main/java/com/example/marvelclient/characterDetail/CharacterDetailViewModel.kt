package com.example.marvelclient.characterDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelclient.avengers.Avenger
import com.example.marvelclient.database.CharacterRepository
import com.example.marvelclient.model.character.Character
import com.example.marvelclient.model.comic.Comic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val repository: CharacterRepository
) : ViewModel() {
    val characterComics: MutableLiveData<List<Comic>?> = MutableLiveData()

    fun getCharacter(id: Int): LiveData<Character> = repository.getCharacterById(id)

    fun getCharacterComics(id:Int){
        viewModelScope.launch {
            val response = repository.getCharacterComics(id)
            characterComics.postValue(response)
        }
    }

    fun addAvenger(avenger: Avenger){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAvenger(avenger)
        }
    }

    fun ifAvengerExists(id: Int): Boolean{
        val avenger = repository.ifAvengerExists(id)?.value
        avenger?.let {
            return true
        }
        return false
    }
}