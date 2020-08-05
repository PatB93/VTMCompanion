package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nokey.vtmcompanion.NavigationFragment
import com.nokey.vtmcompanion.databinding.FragmentDisciplineSelectionBinding

class DisciplineSelectionFragment: NavigationFragment<FragmentDisciplineSelectionBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisciplineSelectionBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }
}