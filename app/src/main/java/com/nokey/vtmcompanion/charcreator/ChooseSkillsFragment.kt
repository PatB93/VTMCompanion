package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nokey.vtmcompanion.NavigationFragment
import com.nokey.vtmcompanion.databinding.FragmentChooseSkillsBinding

class ChooseSkillsFragment : NavigationFragment<FragmentChooseSkillsBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseSkillsBinding.inflate(layoutInflater, container, false).also {
            it.skillAssignment.adapter = ChooseSkillAdapter()
            it.nextButton.setOnClickListener {
                ChooseSkillsFragmentDirections.actionSkillAssignmentDisciplineSelection().navigate()
            }
        }
        return binding?.root
    }
}
