package com.nokey.vtmcompanion.data

import timber.log.Timber
import javax.inject.Inject

class CharacterManager @Inject constructor(private val characterDao: CharacterDao) {

    fun createCharacter(character: Character) {
        Timber.d("${character.characterName} Was added to the Character Database")
        characterDao.addNewCharacter(character)
    }
}