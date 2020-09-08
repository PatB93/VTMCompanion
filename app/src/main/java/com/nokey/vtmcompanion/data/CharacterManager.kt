package com.nokey.vtmcompanion.data

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import timber.log.Timber
import javax.inject.Inject

class CharacterManager @Inject constructor(
    private val characterDao: CharacterDao,
    private val sharedPreferences: SharedPreferences
) {

    private val usePreviousCharacter = -1

    suspend fun createCharacter(character: Character) {
        Timber.d("${character.characterName} Was added to the Character Database")
        characterDao.addNewCharacter(character)
    }

    fun getCharacter(characterId: Int = usePreviousCharacter): LiveData<Character> {
        return if (characterId == usePreviousCharacter) {
            getCharacterFromSharedPrefsOrChooseDefault()
        } else {
            sharedPreferences.setLastUsedCharacterId(characterId)
            characterDao.getCharacterWithId(characterId)
        }
    }

    private fun getCharacterFromSharedPrefsOrChooseDefault(): LiveData<Character> {
        val lastUsedCharacter = sharedPreferences.getLastUsedCharacterId()
        return if (lastUsedCharacter == usePreviousCharacter) {
            characterDao.getFirstCharacter().also {
                sharedPreferences.setLastUsedCharacterId(it.value?.id ?: usePreviousCharacter)
            }
        } else {
            characterDao.getCharacterWithId(lastUsedCharacter)
        }
    }
}