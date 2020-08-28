package com.nokey.vtmcompanion.data

import android.content.SharedPreferences
import timber.log.Timber
import javax.inject.Inject

class CharacterManager @Inject constructor(
    private val characterDao: CharacterDao,
    private val sharedPreferences: SharedPreferences
) {

    private val usePreviousCharacter = -1

    fun createCharacter(character: Character) {
        Timber.d("${character.characterName} Was added to the Character Database")
        characterDao.addNewCharacter(character)
    }

    fun getCharacter(characterId: Int = usePreviousCharacter): Character {
        return if (characterId == usePreviousCharacter) {
            characterDao.getCharacterWithId(sharedPreferences.getLastUsedCharacterId())
        } else {
            sharedPreferences.setLastUsedCharacterId(characterId)
            characterDao.getCharacterWithId(characterId)
        }
    }
}