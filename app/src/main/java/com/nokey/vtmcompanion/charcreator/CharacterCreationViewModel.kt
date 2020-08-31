package com.nokey.vtmcompanion.charcreator

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nokey.vtmcompanion.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterCreationViewModel @ViewModelInject constructor(
    private val characterManager: CharacterManager
) : ViewModel() {
    lateinit var sireName: String
    lateinit var selectedClan: Clan
    lateinit var skills: DistributionTypes
    var attributes: List<Attributes> = listOf()
    var disciplines = Array(2) { Discipline.ANIMALISM }


    // TODO : Suspend?
    fun finishSetup() {
        viewModelScope.launch(Dispatchers.IO) {
            val character =
                Character(
                    sireName,
                    sireName,
                    selectedClan,
                    skills,
                    attributes,
                    disciplines.toList()
                )

            characterManager.createCharacter(character)
        }
    }

    fun setDisciplines(firstDiscipline: Discipline, secondDiscipline: Discipline) {
        disciplines[0] = firstDiscipline
        disciplines[1] = secondDiscipline
    }
}

