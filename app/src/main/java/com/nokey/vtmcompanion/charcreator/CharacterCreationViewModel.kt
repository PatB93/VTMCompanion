package com.nokey.vtmcompanion.charcreator

import androidx.lifecycle.ViewModel
import com.nokey.vtmcompanion.data.*
import javax.inject.Inject

class CharacterCreationViewModel @Inject constructor(val characterManager: CharacterManager) : ViewModel() {
    lateinit var sireName: String
    lateinit var selectedClan: Clans
    lateinit var skills: SkillDistributions
    var attributes: MutableMap<Attributes, Short> = mutableMapOf() // Pair of Attribute -> Dots

    fun finishSetup() {

    }
}

