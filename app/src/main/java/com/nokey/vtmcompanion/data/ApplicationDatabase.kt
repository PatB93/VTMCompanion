package com.nokey.vtmcompanion.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Character::class], version = 1)
@TypeConverters(CharacterConverters::class)
abstract class ApplicationDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "app_db"
    }

    abstract fun characterDao(): CharacterDao
}