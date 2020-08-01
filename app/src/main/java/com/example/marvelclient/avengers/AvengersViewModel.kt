package com.example.marvelclient.avengers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelclient.database.CharacterRepository
import kotlinx.coroutines.launch

class AvengersViewModel(
    private val repository: CharacterRepository
) : ViewModel(){

    fun getAvengers() = repository.getAvengers()

    fun insertAvenger(avenger: Avenger){
        viewModelScope.launch {
            repository.insertAvenger(avenger)
        }
    }
}