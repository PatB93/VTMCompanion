package com.nokey.vtmcompanion.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CharacterDao {

    // TODO : TechDebt - Think about implications of replacing characters of same name (int ID might be a better indicator)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewCharacter(character: Character)
}