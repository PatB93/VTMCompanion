package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nokey.vtmcompanion.NavigationFragment
import com.nokey.vtmcompanion.databinding.FragmentAttributesAssignmentBinding

class AttributesAssignmentFragment: NavigationFragment<FragmentAttributesAssignmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAttributesAssignmentBinding.inflate(inflater, container, false).also {
            it.attributeList.adapter = AttributeAssignmentAdapter()
            it.nextButton.setOnClickListener {
                AttributesAssignmentFragmentDirections.actionAttributeAssignmentToSkillAssignment().navigate()
            }
        }
        return binding?.root
    }
}