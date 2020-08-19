package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.data.Discipline
import com.nokey.vtmcompanion.databinding.FragmentDisciplineSelectionBinding

class DisciplineSelectionFragment : DaggerNavigationFragment<FragmentDisciplineSelectionBinding>() {

    private val viewModel by navGraphViewModels<CharacterCreationViewModel>(R.id.char_creation_graph) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentDisciplineSelectionBinding.inflate(layoutInflater, container, false).also {
                it.firstDiscipline.setAdapter(
                    ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_dropdown_item,
                        resources.getStringArray(
                            R.array.disciplines
                        )
                    )
                )
                it.secondDiscipline.setAdapter(
                    ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_dropdown_item,
                        resources.getStringArray(
                            R.array.disciplines
                        )
                    )
                )
                it.nextButton.setOnClickListener { _ ->
                    viewModel.setDisciplines(
                        Discipline.values()[it.firstDiscipline.selectedIndex],
                        Discipline.values()[it.secondDiscipline.selectedIndex]
                    )
                    viewModel.finishSetup()
                }
            }
        return binding?.root
    }
}
