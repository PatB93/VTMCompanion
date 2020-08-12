package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.NavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.databinding.FragmentAttributesAssignmentBinding

class AttributesAssignmentFragment: NavigationFragment<FragmentAttributesAssignmentBinding>() {
    private val viewModel by navGraphViewModels<CharacterCreationViewModel>(R.id.char_creation_graph)
    private val adapter = AttributeAssignmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAttributesAssignmentBinding.inflate(inflater, container, false).also {
            it.attributeList.adapter = adapter
            it.nextButton.setOnClickListener {
                for (views: AttributeViewHolder in adapter.attributeViews) {
                    viewModel.attributes[views.attribute] = views.dots
                }
                AttributesAssignmentFragmentDirections.actionAttributeAssignmentToSkillAssignment()
                    .navigate()
            }
        }
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        if (viewModel.attributes.size == 9) {
            adapter.applyAttributes(viewModel.attributes)
        }
    }
}
