package com.nokey.vtmcompanion.module

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.nokey.vtmcompanion.data.ApplicationDatabase
import com.nokey.vtmcompanion.data.CharacterDao
import com.nokey.vtmcompanion.data.SharedPrefsNames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityRetainedComponent::class)
class DataModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ApplicationDatabase {
        return Room.databaseBuilder(
            context,
            ApplicationDatabase::class.java,
            ApplicationDatabase.DB_NAME
        ).build()
    }

    @Provides
    fun provideCharacterDao(database: ApplicationDatabase): CharacterDao = database.characterDao()

    @Provides
    fun provideSharedPrefs(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(SharedPrefsNames.APP_NAME, MODE_PRIVATE)
}