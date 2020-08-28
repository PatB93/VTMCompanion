package com.nokey.vtmcompanion.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character WHERE id == :id")
    fun getCharacterWithId(id: Int): Character

    // TODO : TechDebt - Think about implications of replacing characters of same name (int ID might be a better indicator)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewCharacter(character: Character)
}