package com.nokey.vtmcompanion.data

import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
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

    private lateinit var subject: CharacterManager

    @BeforeAll
    fun setup() {
        subject = CharacterManager(characterDao)
    }

    @Nested
    inner class CreateCharacter {

        @Test
        fun addNewCharacterToDatabase() {
            val character = mockk<Character>()
            subject.createCharacter(character)
            verify { characterDao.addNewCharacter(character) }
        }
    }

}