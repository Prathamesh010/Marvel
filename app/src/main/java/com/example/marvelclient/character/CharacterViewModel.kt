package com.example.marvelclient.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelclient.database.CharacterRepository
import com.example.marvelclient.model.character.Character
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    init {
        viewModelScope.launch{
            repository.refreshCharacter()
        }
    }

    fun getCharacters(): LiveData<List<Character>> = repository.getCharacter()
}
