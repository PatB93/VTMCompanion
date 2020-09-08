package com.nokey.vtmcompanion.data

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CharacterManagerTest {

    @MockK(relaxed = true)
    private lateinit var characterDao: CharacterDao

    @MockK()
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
//            subject.createCharacter(character)
//            verify { characterDao.addNewCharacter(character) }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetCharacter {

        @BeforeEach
        fun resetMocks() {
            clearMocks(characterDao, sharedPreferences)
        }

        @Test
        fun noIdAndSharedPrefsReturnsDefault_getFirstCharacterFromDB() {
            val character = mockk<Character>()
            every { character.id } returns 2
            every { sharedPreferences.getLastUsedCharacterId() } returns -1
            every { characterDao.getFirstCharacter() } returns MutableLiveData(character)

            subject.getCharacter()

            verifyAll {
                sharedPreferences.getLastUsedCharacterId()
                characterDao.getFirstCharacter()
                sharedPreferences.setLastUsedCharacterId(2)
            }
            verify(exactly = 0) {
                characterDao.getCharacterWithId(any()) wasNot Called
            }
        }

        @Test
        fun noIdAndSharedPrefsHasValue_getIdFromSharedPrefs() {
            every { sharedPreferences.getLastUsedCharacterId() } returns 1

            subject.getCharacter()

            verify {
                sharedPreferences.getLastUsedCharacterId()
                characterDao.getCharacterWithId(1)
            }
            verify(exactly = 0) {
                sharedPreferences.setLastUsedCharacterId(any())
                characterDao.getFirstCharacter()
            }
        }

        @Test
        fun idProvided_getCharacterAndSetSharedPrefs() {
            subject.getCharacter(1)

            verifyAll {
                characterDao.getCharacterWithId(1)
                sharedPreferences.setLastUsedCharacterId(1)
            }
            verify(exactly = 0) {
                characterDao.getFirstCharacter()
                sharedPreferences.getLastUsedCharacterId()
            }
        }

        @Test
        fun idProvided3_throwsException() {
            assertThrows<InterruptedException> { sharedPreferences.setLastUsedCharacterId(3) }
        }
    }
}
