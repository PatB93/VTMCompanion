package com.nokey.vtmcompanion.charcreator

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nokey.vtmcompanion.data.*
import kotlinx.coroutines.*

class CharacterCreationViewModel @ViewModelInject constructor(
    private val characterManager: CharacterManager,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    lateinit var sireName: String
    lateinit var selectedClan: Clan
    lateinit var skills: DistributionTypes
    var attributes: MutableMap<Attributes, Short> = mutableMapOf() // Map of Attribute -> Dots
    var disciplines = Array(2) { Discipline.ANIMALISM }

    fun finishSetup() {
        viewModelScope.launch(Dispatchers.IO) {
            val character =
                Character(sireName, sireName, selectedClan, skills, attributes, disciplines.toList())

            characterManager.createCharacter(character)
        }
    }

    fun setDisciplines(firstDiscipline: Discipline, secondDiscipline: Discipline) {
        disciplines[0] = firstDiscipline
        disciplines[1] = secondDiscipline
    }
}

