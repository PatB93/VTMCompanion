package com.nokey.vtmcompanion.module

import android.content.Context
import androidx.room.Room
import com.nokey.vtmcompanion.VtmApplication
import com.nokey.vtmcompanion.data.ApplicationDatabase
import com.nokey.vtmcompanion.data.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(FragmentComponent::class)
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
}