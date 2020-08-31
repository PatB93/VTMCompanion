package com.nokey.vtmcompanion.charsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.databinding.FragmentCharacterSheetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterSheetFragment : DaggerNavigationFragment<FragmentCharacterSheetBinding>() {
    private val viewModel by navGraphViewModels<CharacterSheetViewModel>(R.id.character_sheet) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterSheetBinding.inflate(layoutInflater, container, false).also {
            init(it)
        }

        return binding?.root
    }

    private fun init(binding: FragmentCharacterSheetBinding) {
        viewModel.getCharacter().observe(viewLifecycleOwner, Observer {
            binding.attributeView.adapter = AttributeDotsAdapter(it.attributes.toList())
        })
    }
}