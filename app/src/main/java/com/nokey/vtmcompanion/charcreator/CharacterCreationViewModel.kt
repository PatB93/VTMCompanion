package com.nokey.vtmcompanion.charcreator

import androidx.lifecycle.ViewModel
import com.nokey.vtmcompanion.data.Attributes
import com.nokey.vtmcompanion.data.Clans

class CharacterCreationViewModel : ViewModel() {
    lateinit var sireName: String
    lateinit var selectedClan: Clans
    var attributes: MutableMap<Attributes, Short> = mutableMapOf() // Pair of Attribute -> Dots
}

