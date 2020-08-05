package com.nokey.vtmcompanion.charcreator

import androidx.lifecycle.ViewModel
import com.nokey.vtmcompanion.data.Clans

class CharacterCreationViewModel: ViewModel() {
    lateinit var sireName: String
    lateinit var selectedClan: Clans
}
