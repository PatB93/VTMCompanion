package com.nokey.vtmcompanion.data

import android.content.SharedPreferences
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CharacterManagerTest {

    @MockK(relaxed = true)
    private lateinit var characterDao: CharacterDao

    @MockK(relaxed = true)
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var subject: CharacterManager

    @BeforeAll
    fun setup() {
        subject = CharacterManager(characterDao, sharedPreferences)
    }

    @Nested
    inner class CreateCharacter {

        @Test
        fun addNewCharacterToDatabase() {
            val character = mockk<Character>(relaxed = true)
            subject.createCharacter(character)
            verify { characterDao.addNewCharacter(character) }
        }
    }

    @Nested
    inner class GetCharacter {

        @Test
        fun noId_getIdFromSharedPrefs() {
            subject.getCharacter()

            verify { characterDao.getCharacterWithId(sharedPreferences.getLastUsedCharacterId()) }
        }

        @Test
        fun idProvided_getCharacterAndSetSharedPrefs() {
            subject.getCharacter(1)

            verifyAll {
                characterDao.getCharacterWithId(1)
                sharedPreferences.setLastUsedCharacterId(1)
            }
        }
    }

}