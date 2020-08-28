package com.nokey.vtmcompanion.charcreator

import androidx.lifecycle.SavedStateHandle
import com.nokey.vtmcompanion.data.*
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CharacterCreationViewModelTest {

    @MockK(relaxed = true)
    lateinit var characterManager: CharacterManager

    @MockK
    lateinit var savedStateHandle: SavedStateHandle

    lateinit var subject: CharacterCreationViewModel

    @BeforeAll
    fun setupCharacter() {
        subject = CharacterCreationViewModel(characterManager, savedStateHandle)

        subject.sireName = "Sire"
        subject.selectedClan = Clan.BRUJAH
        subject.skills = DistributionTypes.Balanced
        subject.attributes = mutableMapOf(AttributeSet(Attributes.Charisma, 1))
        subject.disciplines = arrayOf(Discipline.ANIMALISM, Discipline.ANIMALISM)
    }

    @Nested
    inner class FinishSetup {

        @Test
        fun saveCharacterToDatabase() {
            val character = Character(
                    subject.sireName,
                    subject.sireName,
                            subject.selectedClan,
                            subject.skills,
                            subject.attributes,
                            subject.disciplines.toList()
                    )

            subject.finishSetup()

            verify { characterManager.createCharacter(character) }
        }
    }
}