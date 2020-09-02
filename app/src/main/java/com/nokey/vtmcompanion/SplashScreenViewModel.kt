package com.nokey.vtmcompanion

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.nokey.vtmcompanion.data.CharacterManager

class SplashScreenViewModel @ViewModelInject constructor(private val characterManager: CharacterManager) :
    ViewModel() {

    fun checkForCharacter(): LiveData<Boolean> = map(characterManager.getCharacter()) {
        it != null
    }
}