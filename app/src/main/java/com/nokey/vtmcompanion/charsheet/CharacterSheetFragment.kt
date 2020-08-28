package com.nokey.vtmcompanion.charsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.databinding.FragmentCharacterSheetBinding

class CharacterSheetFragment : DaggerNavigationFragment<FragmentCharacterSheetBinding>() {
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharacterSheetBinding.inflate(layoutInflater, container, false)

        return binding?.root
    }
}