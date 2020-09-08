package com.nokey.vtmcompanion.charsheet

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nokey.vtmcompanion.data.Character
import com.nokey.vtmcompanion.data.CharacterManager

class CharacterSheetViewModel @ViewModelInject constructor(
    private val characterManager: CharacterManager
) : ViewModel() {

    fun getCharacter(): LiveData<Character> = characterManager.getCharacter()
}