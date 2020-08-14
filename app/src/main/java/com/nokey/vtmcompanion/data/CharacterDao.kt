package com.nokey.vtmcompanion.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CharacterDao {
    @Insert
    fun addNewCharacter(character: Character)
}