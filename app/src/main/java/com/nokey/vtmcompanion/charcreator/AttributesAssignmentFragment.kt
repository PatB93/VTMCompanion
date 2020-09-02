package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.data.Attributes
import com.nokey.vtmcompanion.databinding.FragmentAttributesAssignmentBinding
import com.nokey.vtmcompanion.hideKeyboard

class AttributesAssignmentFragment :
    DaggerNavigationFragment<FragmentAttributesAssignmentBinding>() {
    private val viewModel by navGraphViewModels<CharacterCreationViewModel>(R.id.char_creation_graph) {
        defaultViewModelProviderFactory
    }
    private val adapter = AttributeAssignmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAttributesAssignmentBinding.inflate(inflater, container, false)
            .also { binding ->
                binding.attributeList.adapter = adapter
                binding.nextButton.setOnClickListener {
                    viewModel.attributes = adapter.attributes
                    AttributesAssignmentFragmentDirections.actionAttributeAssignmentToSkillAssignment()
                        .navigate()
                }
            }
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
//        if (viewModel.attributes.size == 9) {
//            adapter.applyAttributes(viewModel.attributes)
//        }
    }

    override fun onPause() {
        super.onPause()
        view?.hideKeyboard()
    }
}
