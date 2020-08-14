package com.nokey.vtmcompanion.data

import javax.inject.Inject

class CharacterManager @Inject constructor(private val characterDao: CharacterDao) {

    fun createCharacter(character: Character) {
        characterDao.addNewCharacter(character)
    }
}