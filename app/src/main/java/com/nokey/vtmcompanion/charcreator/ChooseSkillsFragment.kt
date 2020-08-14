package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.databinding.FragmentChooseSkillsBinding

class ChooseSkillsFragment : DaggerNavigationFragment<FragmentChooseSkillsBinding>() {

    private val viewModel by navGraphViewModels<CharacterCreationViewModel>(R.id.char_creation_graph) {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseSkillsBinding.inflate(layoutInflater, container, false).also {
            val chooseSkillAdapter = ChooseSkillAdapter()
            it.skillAssignment.adapter = chooseSkillAdapter
            it.nextButton.setOnClickListener {
                viewModel.apply {
                    skills = chooseSkillAdapter.skillDistribution
                    finishSetup()
                }
                ChooseSkillsFragmentDirections.actionSkillAssignmentDisciplineSelection().navigate()
            }
        }
        return binding?.root
    }
}
