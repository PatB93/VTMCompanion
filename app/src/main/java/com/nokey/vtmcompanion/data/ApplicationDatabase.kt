package com.nokey.vtmcompanion.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Character::class], version = 1)
abstract class ApplicationDatabase() : RoomDatabase() {
    companion object {
        const val DB_NAME = "app_db"
    }
    abstract fun characterDao(): CharacterDao
}