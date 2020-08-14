package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.databinding.FragmentDisciplineSelectionBinding

class DisciplineSelectionFragment : DaggerNavigationFragment<FragmentDisciplineSelectionBinding>() {

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
            }
        return binding?.root
    }
}
