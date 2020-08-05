package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.NavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.databinding.FragmentNameSireBinding

class NameSireFragment: NavigationFragment<FragmentNameSireBinding>() {
    private val viewModel by navGraphViewModels<CharacterCreationViewModel>(R.id.char_creation_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNameSireBinding.inflate(inflater, container, false).also {
            it.nextButton.setOnClickListener { _ ->
                if (it.sireNameEdit.text?.isNotEmpty() == true) {
                    viewModel.sireName = it.sireNameEdit.text.toString()
                    NameSireFragmentDirections.actionNameSireToAttributeAssignment().navigate()
                } else {
                    Toast.makeText(requireContext(), R.string.empty_name_toast, Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding?.root
    }
}
