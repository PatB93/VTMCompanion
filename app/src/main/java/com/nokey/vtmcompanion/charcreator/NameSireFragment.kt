package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nokey.vtmcompanion.NavigationFragment
import com.nokey.vtmcompanion.databinding.FragmentNameSireBinding

class NameSireFragment: NavigationFragment<FragmentNameSireBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNameSireBinding.inflate(inflater, container, false).apply {
            nextButton.setOnClickListener {
                NameSireFragmentDirections.actionNameSireToAttributeAssignment().navigate()
            }
        }
        return binding?.root
    }
}